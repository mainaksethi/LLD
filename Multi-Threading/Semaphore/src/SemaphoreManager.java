import java.util.ArrayList;
import java.util.List;

public class SemaphoreManager {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        List<Thread> consumers = new ArrayList<>();
        List<Thread> producers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Integer val = i;
            Thread t = new Thread(() -> {
                try {
                    semaphore.acquirePermit();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, "Thread-"+val);
            t.start();
            producers.add(t);
        }
        for (int i = 0; i < 5; i++) {
            Integer val = i;
            Thread t = new Thread(() -> {
                try {
                    semaphore.releasePermit();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, "Thread-"+(Integer)(val+11));
            t.start();
            consumers.add(t);
        }
        producers.stream().forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        consumers.stream().forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
