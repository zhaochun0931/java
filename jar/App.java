//package com.mycompany.app;
import java.util.*;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws Exception
    {

        Greeter.greet("Alice");

        System.out.println( "It will print the current time every sec." );
        
        while (true){
            
            Date current_now = new Date();
            System.out.println("The current time is: " + current_now);
            Thread.sleep(1000);


        }
    }
}
