import java.util.ArrayList;
import java.util.List;

public class BoundedBufferMain {

    public static void main(String[] args) {
        List<Connection> list = new ArrayList<>();
        list.add(new Connection("c1"));
        list.add(new Connection("c2"));
        BoundedBuffer boundedBuffer = new BoundedBuffer(10, list);
        System.out.println(boundedBuffer.getConnection().getId());
        System.out.println(boundedBuffer.getConnection().getId());

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boundedBuffer.getConnection();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boundedBuffer.getConnection();
            }
        });
        t1.start();
        t2.start();
    }
}
