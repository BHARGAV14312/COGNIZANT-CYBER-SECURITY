import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ConcurrentHashMap;

// Thread task class that simulates web page retrieval
class CrawlerTask implements Callable<String> {
    private String url;

    public CrawlerTask(String url) {
        this.url = url;
    }

    @Override
    public String call() throws Exception {
        // Simulate web page retrieval with a delay
        Thread.sleep(1000);
        return "Content of " + url;
    }
}

// Main class to simulate the web crawler
public class WebCrawler {

    private static final int MAX_THREADS = 5;
    private static ConcurrentHashMap<String, String> crawledData = new ConcurrentHashMap<>();
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREADS);

        // List of URLs to be crawled
        String[] urls = {
            "http://example.com/page1",
            "http://example.com/page2",
            "http://example.com/page3",
            "http://example.com/page4",
            "http://example.com/page5",
            "http://example.com/page6",
            "http://example.com/page7"
        };

        // Submit crawling tasks to the executor service
        for (String url : urls) {
            executorService.submit(() -> {
                try {
                    CrawlerTask task = new CrawlerTask(url);
                    String result = task.call();
                    crawledData.put(url, result);
                    System.out.println("Crawled: " + url);
                    counter.incrementAndGet();
                } catch (Exception e) {
                    System.out.println("Failed to crawl: " + url);
                }
            });
        }

        // Shutdown the executor service and wait for tasks to complete
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        // Display the results
        System.out.println("Crawling completed. Total pages crawled: " + counter.get());
        crawledData.forEach((url, content) -> System.out.println(url + ": " + content));
    }
}
