public class App2 implements Runnable {
  
  public static void main(String[] args) {
    App2 obj = new Main();
    Thread thread = new Thread(obj);
    thread.start();
    System.out.println("This code is outside of the thread");
  }
  
  public void run() {
    System.out.println("This code is running in a thread");
  }
  
}
