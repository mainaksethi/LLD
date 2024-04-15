import java.time.Instant;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeDeferredCallback {

    public ThreadSafeDeferredCallback() {
        threadPool = Executors.newFixedThreadPool(10);
    }

    private PriorityQueue<CallbackNode> pq = new PriorityQueue<>(new Comparator<CallbackNode>() {
        @Override
        public int compare(CallbackNode o1, CallbackNode o2) {
            if (o1.at == o2.at) {
                return 0;
            }
            return o1.at < o2.at ? -1 : 1;
        }
    });

    private ReentrantLock lock = new ReentrantLock();

    private ExecutorService threadPool;

    Condition newCallbackArrived = lock.newCondition();

    public void executeCallback() {
        Thread t = new Thread(() -> {
            while(true) {
                lock.lock();
                while(!pq.isEmpty() && pq.peek().at < Instant.now().getEpochSecond()) {
                    CallbackNode callbackNode = pq.peek();
                    threadPool.submit(callbackNode.callback.runnable);
                    pq.poll();
                }
                try {
                    Long sleepDuration = findSleepDuration();
                    newCallbackArrived.await(sleepDuration, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.unlock();
            }
        });
        t.setDaemon(true);
        t.start();
    }

    private Long findSleepDuration() {
        if (!pq.isEmpty()) {
            return pq.peek().at - Instant.now().getEpochSecond();
        } else {
            return 5L;
        }

    }

    public void registerCallback(CallbackNode callbackNode) {
        lock.lock();
        pq.add(callbackNode);
        newCallbackArrived.signal();
        lock.unlock();
    }

    public class ThreadSafeCallbackFactory {
        public static ThreadSafeDeferredCallback getThreadSafeDeferredCallback() {
            ThreadSafeDeferredCallback threadSafeDeferredCallback = new ThreadSafeDeferredCallback();
            threadSafeDeferredCallback.executeCallback();
            return threadSafeDeferredCallback;
        }
    }
}

