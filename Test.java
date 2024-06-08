import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        // Simulate some work before scheduling the download completion message
        System.out.println("Starting download process...");

        // Schedule the download completion message with a 2-second delay
        executor.schedule(() -> System.out.println("Download complete!"), 1, TimeUnit.MINUTES);

        // Simulate some additional work after scheduling
        System.out.println("Performing other tasks while download continues...");

        // Shutdown the executor service (optional)
        executor.shutdown();
    }
}