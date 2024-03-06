import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BoundedBuffer {

    private ThreadSafeLinkedList<Connection> pool;
    private int poolSize;

    public BoundedBuffer(int poolSize, List<Connection> connections) {
        this.poolSize = poolSize;
        pool = new ThreadSafeLinkedList<Connection>();
        for (Connection c: connections) {
            pool.insertNode(new Node<>(c));
        }
    }

    public Connection getConnection() {
        Node<Connection> node = pool.popFromFront();
        return node.getVal();
    }

    public void putConnection(Connection c) {
        pool.insertNode(new Node<>(c));
    }

}