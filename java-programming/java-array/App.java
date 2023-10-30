public class App {

    public static void main(String[] args) {

        int[] a1;
        int a2[];
        int [] a3 = {1,2,10,20};
        a1 = a3;
        a2 = a3;



        for (int i = 0; i < a3.length; i++)
        {
            System.out.println(a3[i]);
        }


        System.out.println(a1[2]);

        System.out.println(a2[1]);




    }
}
