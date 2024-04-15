import java.util.*;
import java.util.concurrent.*;

public class MultiThreadedWebCrawler {
    private ConcurrentMap<String, Object> lockMap = new ConcurrentHashMap<String, Object>();

    private Map<String, Boolean> visited = new HashMap<>();

    private HtmlParser htmlParser;

    private Queue<Future<List<String>>> futureQueue = new ArrayDeque<>();

    private ExecutorService threadPool;

    public MultiThreadedWebCrawler(int threads, HtmlParser htmlParser) {
        this.htmlParser = htmlParser;
        threadPool = Executors.newFixedThreadPool(threads);
    }

    private Future<List<String>> crawlUrl(String url) {
        if (canCrawlWithStringBasedLock(url)) {
            Future<List<String>> future = threadPool.submit(new Callable<List<String>>() {
                @Override
                public List<String> call() throws Exception {
                    return htmlParser.getUrls(url);
                }
            });
            return future;
        }
        return null;
    }

    public List<String> crawl(String url) throws ExecutionException, InterruptedException {
        Future<List<String>> future = crawlUrl(url);
        List<String> crawledUrls = new ArrayList<>();
        crawledUrls.add(url);
        futureQueue.add(future);
        while(!futureQueue.isEmpty()) {
            Queue<Future<List<String>>> futureQueue2 = new ArrayDeque<>();
            while(!futureQueue.isEmpty()) {
                Future<List<String>> f1 = futureQueue.poll();
                if (f1.isDone()) {
                    List<String> newUrls = f1.get();
                    crawledUrls.addAll(newUrls);
                    // TODO: filtering based on domain can be done here.
                    List<Future<List<String>>> futures = newUrls.stream().map((newUrl) -> crawlUrl(newUrl)).toList();
                    futureQueue2.addAll(futures);
                } else {
                    futureQueue2.add(f1);
                }
            }
            futureQueue.addAll(futureQueue2);
        }
        threadPool.shutdown();
        return crawledUrls;
    }

    public boolean canCrawlWithStringBasedLock(String url) {
        synchronized (getLock(url)) {
            if (visited.get(url) == null) {
                visited.put(url, true);
                return true;
            } else {
                return false;
            }
        }
    }

    public Object getLock(String url) {
        lockMap.putIfAbsent(url, new Object());
        return lockMap.get(url);
    }
}