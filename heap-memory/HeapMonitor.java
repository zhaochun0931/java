import java.util.ArrayList;
import java.util.List;

public class HeapMonitor {
    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        List<byte[]> allocations = new ArrayList<>(); // keep references so GC won't free

        while (true) {
            // Allocate 10 MB every 2 seconds
            byte[] block = new byte[10 * 1024 * 1024];
            allocations.add(block);

            long maxMemory   = runtime.maxMemory();   // Max heap JVM will attempt
            long totalMemory = runtime.totalMemory(); // Current heap allocated
            long freeMemory  = runtime.freeMemory();  // Free within current heap
            long usedMemory  = totalMemory - freeMemory;

            System.out.printf(
                "Allocated new 10MB block -> Max: %d MB | Allocated: %d MB | Used: %d MB | Free: %d MB | Blocks: %d%n",
                maxMemory / (1024 * 1024),
                totalMemory / (1024 * 1024),
                usedMemory / (1024 * 1024),
                freeMemory / (1024 * 1024),
                allocations.size()
            );

            Thread.sleep(2000); // allocate every 2 seconds
        }
    }
}
