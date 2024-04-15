import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Similar question was asked in uber lld where we need to take lock on string object.
 * Learning:
 * 1. We cannot take do a synchronized method as all urls are independent and can be parsed parallelly.
 *    IMPORTANT: NO LOCK ON STRING OBJECT.
 *      reason: Since strings are immutable we are not advised to take lock on it since its used as hash for
 *      map and can lead to consequences.
 *      detail: https://chat.openai.com/c/0df00a16-6840-4058-a6f3-20d602a50fa7
 *  2.a Either use a concurrent hashmap for storing string to LockObject map and return lock. No explicit locking is
 *   required here since use of 2 method calls,
 *      a. putIfAbsent() and get() would suffice.
 *  2.b Or directly keep a concurrentHashMap for visited and insert all urls that are visited.
 *
 * 3. Use of callable interface and thread pool.
 */

public class MultiThreadedWebCrawlerManager {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MultiThreadedWebCrawler2 multiThreadedWebCrawler = new MultiThreadedWebCrawler2(10, new HtmlParser());
        List<String> crawledUrls = multiThreadedWebCrawler.crawl("abc.com");
        System.out.println(crawledUrls);
    }
}