import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class BlockingQueueManager {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<Integer>(3);
        Thread producers = new Thread(() -> {
            List<Thread> array = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                int finalI = i;
                Thread t1 = new Thread(() -> {
                    blockingQueue.enqueue(finalI);
                }, "Thread-" + i);
                t1.start();
                array.add(t1);
            }
            array.stream().forEach(t -> {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });
        Thread consumers = new Thread(() -> {
            List<Thread> array = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                final int val = i;
                Thread t1 = new Thread(() -> {
                    blockingQueue.dequeue();
                }, "Thread-" + (Integer)(11+i));
                t1.start();
                array.add(t1);
            }
            array.stream().forEach(t -> {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });
        producers.start();
        consumers.start();
        producers.join();
        consumers.join();
    }

}