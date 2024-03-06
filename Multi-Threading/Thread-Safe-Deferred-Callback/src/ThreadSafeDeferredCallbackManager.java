import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Asked in Hotstar-Interview.
 * Design and implement a thread-safe class that allows registeration of callback methods that are executed after a user
 * specified time interval in seconds has elapsed.
 */
public class ThreadSafeDeferredCallbackManager {
    public static void main(String[] args) throws InterruptedException {
        Long currentTime = Instant.now().getEpochSecond();
        ThreadSafeDeferredCallback threadSafeDeferredCallback =
                ThreadSafeDeferredCallback.ThreadSafeCallbackFactory.getThreadSafeDeferredCallback();
        List<Thread> arr = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            Integer val = i;
            Thread t = new Thread(() -> {
                threadSafeDeferredCallback.registerCallback(
                        new CallbackNode(currentTime + val,
                                new Callback(() ->
                                        System.out.println("Executing callback at " + currentTime + val))));
            });
            t.start();
            arr.add(t);
        }
        arr.stream().forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t = new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t.start();
        t.join();
    }
}
