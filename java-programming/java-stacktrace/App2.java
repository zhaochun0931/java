import java.io.*;
import java.lang.Thread;
import java.time.*;


public class App2 {
    public static void main(String[] args) {

        try{
            LocalTime localtime = LocalTime.now();
            System.out.println(localtime);
            System.out.println("This java program will pause for 10 seconds");


            Thread.sleep(10000);
            LocalTime localtime2 = LocalTime.now();
            System.out.println(localtime2);
            System.out.println("hello world");
            printStackTrace();


        }
        catch (Exception e){
            System.out.println(e);
        }
    }

      public static void printStackTrace() {
        Thread.dumpStack();
    }
}
