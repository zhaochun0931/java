import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MemoryDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting JVM memory stress test...");

        // Show configured heap and off-heap limits
        long maxHeap = Runtime.getRuntime().maxMemory();
        long maxDirect = getMaxDirectMemory();

        System.out.println("Max Heap (-Xmx): " + (maxHeap / (1024 * 1024)) + " MB");
        System.out.println("Max Direct Memory (-XX:MaxDirectMemorySize): " +
                           (maxDirect / (1024 * 1024)) + " MB");

        // Formatter for timestamp
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Keep references so GC cannot free them
        List<byte[]> heapList = new ArrayList<>();
        List<ByteBuffer> offHeapList = new ArrayList<>();

        try {
            // Allocate heap memory every 5 seconds
            while (true) {
                byte[] block = new byte[10 * 1024 * 1024]; // 10 MB
                heapList.add(block);

                String time = LocalDateTime.now().format(fmt);
                System.out.println(time + " | Heap allocated so far: " +
                        (heapList.size() * 10) + " MB");

                Thread.sleep(5000);
            }
        } catch (OutOfMemoryError e) {
            System.err.println("💥 Heap OOM reached!");
        }

        try {
            // Allocate off-heap memory every 5 seconds
            while (true) {
                ByteBuffer buffer = ByteBuffer.allocateDirect(20 * 1024 * 1024); // 20 MB
                offHeapList.add(buffer);

                String time = LocalDateTime.now().format(fmt);
                System.out.println(time + " | Off-heap allocated so far: " +
                        (offHeapList.size() * 20) + " MB");

                Thread.sleep(5000);
            }
        } catch (OutOfMemoryError e) {
            System.err.println("💥 Off-heap OOM reached!");
        }

        System.out.println("Test finished. Sleeping for observation...");
        Thread.sleep(60_000);
    }

    private static long getMaxDirectMemory() {
        // Check system property
        String prop = System.getProperty("sun.nio.MaxDirectMemorySize");
        if (prop != null && !prop.isEmpty()) {
            try {
                return Long.parseLong(prop);
            } catch (NumberFormatException ignored) {}
        }
        // Fallback: JVM often defaults to -Xmx
        return Runtime.getRuntime().maxMemory();
    }
}
