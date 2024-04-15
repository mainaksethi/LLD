/**
 * Learning:
 * Same lock is shared across different type of threads, putting them in same queue and not using any conditional
 * variables. Signal will wake up
 */
public class ReadWriteLock {

    private Integer readLockCount = 0;

    private boolean isWriteLockTaken = false;

    public synchronized void acquireReadLock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " acquired readLock.");
        while (isWriteLockTaken) {
            this.wait();
        }
        readLockCount++;
    }

    public synchronized void acquireWriteLock() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " acquired writeLock.");
        while(readLockCount > 0 || isWriteLockTaken) {
            this.wait();
        }
        isWriteLockTaken = true;
    }

    public synchronized void releaseReadLock() {
        System.out.println(Thread.currentThread().getName() + " released readLock.");
        readLockCount--;
        if (readLockCount == 0) {
            this.notifyAll();
        }
    }

    public synchronized void releaseWriteLock() {
        System.out.println(Thread.currentThread().getName() + " released write Lock.");
        isWriteLockTaken = false;
        this.notifyAll();
    }
}
