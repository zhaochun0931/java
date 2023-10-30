public class NewArray {

    public static void main(String[] args) {

        System.out.println("new array demo");

        byte[] xxx = new byte[100];
        int xxx_length = xxx.length;

        for (int i = 0; i<100;i++){

            xxx[i] = (byte) i;
            System.out.println(xxx[i]);
        }

        System.out.println("the size of the array is " + xxx_length);


    }
}
