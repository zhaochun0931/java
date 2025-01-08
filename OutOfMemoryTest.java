public class OutOfMemoryTest {

    public static void main(String[] args) {
        // This will try to create new threads continuously.
        int count = 0;
        while (true) {
            try {
                Thread thread = new Thread(() -> {
                    try {
                        // Each thread will simply sleep, to avoid it doing anything else
                        // and consuming other resources.
                        Thread.sleep(Long.MAX_VALUE);
                    } catch (InterruptedException e) {
                        // Handle exception
                    }
                });
                thread.start();
                count++;
                System.out.println("Created thread number: " + count);
            } catch (OutOfMemoryError e) {
                System.err.println("Caught OutOfMemoryError: unable to create new native thread");
                break;
            }
        }
    }
}
