import java.util.ArrayList;
import java.util.List;

/**
 * Imagine you have an application where you have multiple readers and multiple writers. You are asked to design a lock
 * which lets multiple readers read at the same time, but only one writer write at a time.
 *
 * Solution
 * First of all let us define the APIs our class will expose. We'll need two for writer and two for reader. These are:
 *
 * acquireReadLock
 * releaseReadLock
 * acquireWriteLock
 * releaseWriteLock
 * This problem becomes simple if you think about each case:
 *
 * Before we allow a reader to enter the critical section, we need to make sure that there's no writer in progress. It
 * is ok to have other readers in the critical section since they aren't making any modifications
 *
 * Before we allow a writer to enter the critical section, we need to make sure that there's no reader or writer in the
 * critical section.
 */
public class ReadWriteLockManager {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReadWriteLock();
        List<Thread> readers = new ArrayList<>();
        List<Thread> writers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t1 = new Thread(() -> {
                try {
                    readWriteLock.acquireWriteLock();
                    Thread.sleep(1000);
                    readWriteLock.releaseWriteLock();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, "Writer-" + i);
            writers.add(t1);
        }
        for (int i = 0; i < 5; i++) {
            Thread t1 = new Thread(() -> {
                try {
                    readWriteLock.acquireReadLock();
                    Thread.sleep(1000);
                    readWriteLock.releaseReadLock();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, "Reader-" + i);
            readers.add(t1);
        }
        writers.stream().forEach((t) -> {
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        readers.stream().forEach((t) -> {
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
