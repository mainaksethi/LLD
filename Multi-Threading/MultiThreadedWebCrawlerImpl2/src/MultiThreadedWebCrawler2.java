import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadedWebCrawler2 {

    private ExecutorService threadPool;

    private HtmlParser2 htmlParser;

    private ConcurrentLinkedDeque<String> urlsToBeCrawled;

    private ConcurrentHashMap<String, Object> urlLocks;

    private ConcurrentHashMap<String, Boolean> urlsVisited;

    private ReentrantLock lock = new ReentrantLock();

    private Condition newUrlsAddedCondition = lock.newCondition();

    public MultiThreadedWebCrawler2(int threads, HtmlParser2 htmlParser) {
        this.htmlParser = htmlParser;
        threadPool = Executors.newFixedThreadPool(threads);
    }

    // 1. add url
    // 2. call crawlers.
    // 3. crawlers add new url and mark them as visited
    public void crawl(String url) throws InterruptedException {
        urlsToBeCrawled.push(url);

        try {
            lock.lock();
            while(urlsToBeCrawled.isEmpty()) {
                // Note: the lock auto-released here and acquired again when signalled
                newUrlsAddedCondition.await();
                while(!urlsToBeCrawled.isEmpty()) {
                    String newUrl = urlsToBeCrawled.peekFirst();
                    urlsToBeCrawled.pollFirst();
                    threadPool.submit(() -> {
                        parse(newUrl);
                    });
                }
            }
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }

    }

    private void parse(String url) {
        List<String> newUrls = htmlParser.getUrls(url);
        boolean newUrlsAdded = false;
        for (String newUrl: newUrls) {
            boolean canCrawlNewUrl = false;
            synchronized (getLock(newUrl)) {
                if (urlsVisited.get(newUrl) == null) {
                    urlsVisited.put(newUrl, true);
                    canCrawlNewUrl = true;
                }
            }
            if (canCrawlNewUrl) {
                urlsToBeCrawled.add(newUrl);
                newUrlsAdded = true;
            }
        }
        if (newUrlsAdded) {
            try {
                lock.lock();
                newUrlsAddedCondition.signal();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
            }
        }
    }

    private Object getLock(String url) {
        urlLocks.putIfAbsent(url, new Object());
        return urlLocks.get(url);
    }

}