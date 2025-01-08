import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OOMLimit {

    public static void main(String[] args) {
        // Create a fixed thread pool with a specified number of threads.
        ExecutorService threadPool = Executors.newFixedThreadPool(5000); // Limit the number of threads to 100

        // Loop to submit tasks (creating threads) to the thread pool.
        for (int i = 0; i < 5000; i++) {
            threadPool.submit(createSleepTask());
        }

        // Gracefully shut down the thread pool after all tasks are submitted.
        shutdownThreadPool(threadPool);
    }

    /**
     * Creates a task that makes the thread sleep for a long time.
     * This simulates a running thread without consuming excessive CPU.
     */
    private static Runnable createSleepTask() {
        return () -> {
            // Get the current thread and print thread info
            Thread currentThread = Thread.currentThread();
            System.out.println("Thread " + currentThread.getName() + " (ID: " + currentThread.getId() + ") is starting.");

            try {
                // Sleep for 1 hour to simulate a long-running task.
                TimeUnit.HOURS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Reset the interrupt status
                System.err.println("Thread interrupted: " + e.getMessage());
            }

            // Print message when the thread finishes
            System.out.println("Thread " + currentThread.getName() + " (ID: " + currentThread.getId() + ") has finished.");
        };
    }

    /**
     * Gracefully shuts down the thread pool after submitting all tasks.
     */
    private static void shutdownThreadPool(ExecutorService threadPool) {
        threadPool.shutdown(); // Initiates an orderly shutdown

        try {
            // Wait for all tasks to finish or timeout after 1 minute
            if (!threadPool.awaitTermination(1, TimeUnit.MINUTES)) {
                threadPool.shutdownNow(); // Force shutdown if tasks are still running after 1 minute
            }
        } catch (InterruptedException e) {
            threadPool.shutdownNow(); // Force shutdown if interrupted
            Thread.currentThread().interrupt();
        }
    }
}
