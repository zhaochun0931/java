public class MultiClient {
    public static void main(String[] args) {
        int count = 20; // number of clients

        System.out.println("Launching " + count + " parallel clients...");

        Thread[] threads = new Thread[count];

        for (int i = 0; i < count; i++) {
            final int id = i;
            threads[i] = new Thread(() -> {
                SingleClient.runClient(id);
            });
            threads[i].start();
        }

        // Wait for all threads
        for (int i = 0; i < count; i++) {
            try { threads[i].join(); } catch (Exception ignored) {}
        }

        System.out.println("All clients finished.");
    }
}

