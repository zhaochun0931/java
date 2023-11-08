package com.mycompany.app;

public class App {
    public static void main(String[] args) {

        int[] test1;
        String[] test2;

        int test3[];
        String test4[];


        test1 = new int[3];
        test2 = new String[10];


        System.out.println("array demo");

        for (int i = 0; i < test1.length; i++){
            System.out.println(test1[i]);
        }

        for (int i = 0; i < test2.length; i++){
            System.out.println(test2[i]);
        }
    }
}
