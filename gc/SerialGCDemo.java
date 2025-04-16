// SerialGCDemo.java
import java.util.ArrayList;
import java.util.List;

public class SerialGCDemo {
    public static void main(String[] args) {
        List<byte[]> memoryHog = new ArrayList<>();
        int count = 0;

        while (true) {
            // Allocate 1MB chunks
            byte[] block = new byte[1024 * 1024];
            memoryHog.add(block);

            // Avoid out-of-memory: drop some old references
            if (memoryHog.size() > 50) {
                memoryHog.subList(0, 10).clear(); // Clear 10 oldest
            }

            count++;
            if (count % 10 == 0) {
                System.out.println("Allocated " + count + " MB");
            }

            // Sleep to give GC a chance to kick in
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
