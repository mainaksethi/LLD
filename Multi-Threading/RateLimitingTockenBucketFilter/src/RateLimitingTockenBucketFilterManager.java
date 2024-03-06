import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Problem Statement
 * This is an actual interview question asked at Uber and Oracle.
 *
 * Imagine you have a bucket that gets filled with tokens at the rate of 1 token per second. The bucket can hold a maximum of N tokens. Implement a thread-safe class that lets threads get a token when one is available. If no token is available, then the token-requesting threads should block.
 *
 * The class should expose an API called getToken that various threads can call to get a token
 */
public class RateLimitingTockenBucketFilterManager {
    public static void main(String[] args) {
        RateLimitingTokenBucketFilter rateLimitingTokenBucketFilter = new RateLimitingTokenBucketFilter(10L);
        rateLimitingTokenBucketFilter.start();
        List<Thread> array = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Thread t1 = new Thread(() -> {
                try {
                    rateLimitingTokenBucketFilter.consumeToken();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }, "Thread-" + i );
            t1.start();
            array.add(t1);
        }
        array.stream().forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
