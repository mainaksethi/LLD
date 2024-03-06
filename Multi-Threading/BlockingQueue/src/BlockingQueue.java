import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<T> {
    private Deque<T> deque = new ArrayDeque<>();
    private Integer capacity;

    private Integer size = 0;

    private ReentrantLock rl = new ReentrantLock();

    private Condition queueFull = rl.newCondition();

    private Condition queueEmpty = rl.newCondition();

    public BlockingQueue(Integer capacity) {
        this.capacity  = capacity;
    }

    public void enqueue(T object) {
        try {
            rl.lock();
            if (size == capacity) {
                System.out.println(Thread.currentThread().getName() + " waiting for enqueuing as queue is full.");
                queueFull.await();
            }
            deque.add(object);
            size++;
            queueEmpty.signal();
            System.out.println(Thread.currentThread().getName() + " Enqueued object " + object.toString());
            rl.unlock();
        } catch (InterruptedException interruptedException) {
            System.out.println("Error while enqueing by " + Thread.currentThread().getName());
        } finally {
            if (rl.isHeldByCurrentThread()) {
                rl.unlock();
            }
        }
    }

    public T dequeue() {
        try {
            rl.lock();
            if (size == 0) {
                System.out.println(Thread.currentThread().getName() + " waiting for dequing as queue is empty.");
                queueEmpty.await();
            }
            T object = deque.getFirst();
            deque.pop();
            size--;
            // Every pop should give signal to avoid to activate waiting threads.
            queueFull.signal();
            System.out.println(Thread.currentThread().getName() + " Dequeued object " + object.toString());
            rl.unlock();
            return object;
        } catch (InterruptedException interruptedException) {
            System.out.println("Error while enqueing by " + Thread.currentThread().getName());
        } finally {
            // Note: This line is neccesary else give illegal monitor exception.
            if (rl.isHeldByCurrentThread()) {
                rl.unlock();
            }
        }
        return null;
    }
}
