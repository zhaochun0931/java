public class MemoryDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting JVM memory demo...");

        // Allocate heap memory
        byte[] heapData = new byte[100 * 1024 * 1024]; // 100 MB
        System.out.println("Heap allocated: " + heapData.length / (1024 * 1024) + " MB");

        // Allocate off-heap memory
        java.nio.ByteBuffer buffer = java.nio.ByteBuffer.allocateDirect(200 * 1024 * 1024); // 200 MB
        System.out.println("Off-heap allocated: " + buffer.capacity() / (1024 * 1024) + " MB");

        System.out.println("Sleeping for observation...");
        Thread.sleep(60_000); // keep alive for monitoring
    }
}
