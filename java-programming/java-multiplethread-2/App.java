class MultiThreadDemo implements Runnable{
    public void run(){
        try{
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");

        }
        catch (Exception e){
            System.out.println("exception is caught");

        }
    }
}
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        int n = 10;
        for(int i = 0; i < n; i++){

            Thread xx  = new Thread(new MultiThreadDemo());
            xx.start();

        }
    }
}
