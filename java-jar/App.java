//package com.mycompany.app;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        
        while (true){
            
            Date current_now = new Date();
            System.out.println("The current time is: " + current_now);
            Thread.sleep(1000);


        }
    }
}
