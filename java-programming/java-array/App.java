
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] a1;
        int a2[];
        int [] a3 = {1,2,10,20};
        a1 = a3;
        a2 = a3;

        int[] b2 = new int[5];
        Random myrand = new Random();


        for (int i = 0; i < a3.length; i++) {
            System.out.println(a3[i]);
        }

        System.out.println(a1[2]);
        System.out.println(a2[1]);

        for(int i = 0; i < 5; i++){
            b2[i] = myrand.nextInt(20);
            System.out.println(b2[i]);
        }


    }
}
