public class DeadlockDemo {

    // Shared resources
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        // Create two threads that will cause a deadlock
        Thread thread1 = new Thread(new Task(lock1, lock2));
        Thread thread2 = new Thread(new Task(lock2, lock1));

        thread1.start();
        thread2.start();
    }

    static class Task implements Runnable {
        private final Object firstLock;
        private final Object secondLock;

        Task(Object firstLock, Object secondLock) {
            this.firstLock = firstLock;
            this.secondLock = secondLock;
        }

        @Override
        public void run() {
            try {
                // Acquire the first lock
                synchronized (firstLock) {
                    System.out.println(Thread.currentThread().getName() + " acquired " + firstLock);

                    // Simulate some work
                    Thread.sleep(100);

                    // Attempt to acquire the second lock
                    synchronized (secondLock) {
                        System.out.println(Thread.currentThread().getName() + " acquired " + secondLock);
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
