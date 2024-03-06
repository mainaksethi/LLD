import java.time.Instant;
import java.time.ZonedDateTime;

public class RateLimitingTokenBucketFilter {
    private Long startTime;
    private Integer consumedToken;
    private Object lock = new Object();
    private Long maxTokens;

    public RateLimitingTokenBucketFilter(Long maxTokens) {
        this.startTime = Instant.now().getEpochSecond();
        this.consumedToken = 0;
        this.maxTokens = maxTokens;
    }

    public void start() {
        Thread t1 = new Thread(() -> {
        while(true) {
            synchronized (lock) {
                lock.notifyAll();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        });
        t1.setDaemon(true);
        t1.start();
    }

    public void consumeToken() throws InterruptedException {
        synchronized (lock) {
            while (getCurrentToken() == 0) {
                lock.wait();
            }
            consumedToken++;
            System.out.println("Token consumed by thread " + Thread.currentThread().getName() + " at " + (Instant.now().getEpochSecond() - this.startTime));
        }
    }

    public Long getCurrentToken() {
        return Math.min(this.maxTokens, ((Instant.now().getEpochSecond() - startTime) - consumedToken));
    }
}
