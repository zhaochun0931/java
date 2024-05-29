public class App1 extends Thread {
  
  public static void main(String[] args) {
    
    App1 thread = new App1();
    thread.start();
    System.out.println("This code is outside of the thread");
  }
  
  public void run() {
    System.out.println("This code is running in a thread");
  }
  
}
