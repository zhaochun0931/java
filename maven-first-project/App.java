package com.mycompany.app;

import com.mycompany.app.Test1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Test1 xxx = new Test1();
        xxx.name = "xiaoming";
        xxx.age = 10;
        xxx.tell();
    }
}
