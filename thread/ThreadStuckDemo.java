import java.net.Socket;

public class ThreadStuckDemo {

    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();
    private static final Object WAIT_LOCK = new Object();

    public static void main(String[] args) throws Exception {
        // 1. Infinite Loop (CPU spin)
        new Thread(() -> {
            System.out.println("Started Infinite Loop Thread");
            while (true) {
                // busy loop
            }
        }, "InfiniteLoopThread").start();

        // 2. Deadlock (Thread A)
        new Thread(() -> {
            synchronized (LOCK1) {
                System.out.println("Thread A holding LOCK1...");
                sleep(100);
                synchronized (LOCK2) {
                    System.out.println("Thread A got LOCK2");
                }
            }
        }, "DeadlockThread-A").start();

        // 2. Deadlock (Thread B)
        new Thread(() -> {
            synchronized (LOCK2) {
                System.out.println("Thread B holding LOCK2...");
                sleep(100);
                synchronized (LOCK1) {
                    System.out.println("Thread B got LOCK1");
                }
            }
        }, "DeadlockThread-B").start();

        // 3. Waiting forever
        new Thread(() -> {
            synchronized (WAIT_LOCK) {
                try {
                    System.out.println("Thread waiting forever on WAIT_LOCK...");
                    WAIT_LOCK.wait();  // never notified
                } catch (InterruptedException ignored) {}
            }
        }, "WaitingThread").start();

        // 4. I/O Block
        new Thread(() -> {
            try {
                System.out.println("Thread blocking on socket I/O...");
                // unroutable IP address, will block
                Socket socket = new Socket("10.255.255.1", 12345);
                socket.getInputStream().read();
            } catch (Exception e) {
                // ignore, some OSes fail fast
            }
        }, "IOBlockThread").start();
    }

    private static void sleep(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }
}
