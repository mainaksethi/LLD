import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Java does provide its own implementation of Semaphore, however, Java's semaphore is initialized with an initial number of permits,
 * rather than the maximum possible permits and the developer is expected to take care of always releasing the intended number
 * of maximum permits.
 *
 * Briefly, a semaphore is a construct that allows some threads to access a fixed set of resources in parallel. Always
 * think of a semaphore as having a fixed number of permits to give out. Once all the permits are given out, requesting threads,
 * need to wait for a permit to be returned before proceeding forward.
 *
 * Your task is to implement a semaphore which takes in its constructor the maximum number of permits allowed and is
 * also initialized with the same number of permits.
 */
public class Semaphore {

    private Integer maximumPermits;

    private Integer permitsDistributed = 0;

    private ReentrantLock lock = new ReentrantLock();

    private Condition permitsNotAvailable = lock.newCondition();

    private Condition noPermitsAcquired = lock.newCondition();

    public Semaphore(Integer maximumPermits) {
        this.maximumPermits = maximumPermits;
    }

    public void releasePermit() throws InterruptedException {
        try {
            lock.lock();
            if (permitsDistributed == 0) {
                noPermitsAcquired.await();
            }
            permitsDistributed--;
            permitsNotAvailable.signalAll();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    public void acquirePermit() throws InterruptedException {
        try {
            lock.lock();
            if (permitsDistributed == maximumPermits) {
                permitsNotAvailable.await();
            }
            permitsDistributed++;
            noPermitsAcquired.signalAll();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
}
