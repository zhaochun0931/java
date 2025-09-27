class Worker extends Thread {
    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
            // sleep for 10 seconds
            Thread.sleep(10000);
            System.out.println("Thread " + Thread.currentThread().getId() + " has finished sleeping");
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getId() + " was interrupted");
        } catch (Exception e) {
            System.out.println("exception is caught");
        }
    }
}

public class MultipleThreadDemo {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int n = 10;
        for (int i = 0; i < n; i++) {
            Worker xx = new Worker();
            xx.start();
        }
    }
}
