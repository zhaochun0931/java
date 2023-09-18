class XXXCalculation{
    int a;

    public void XXXAddition(int x, int y){
        a = x + y;
        System.out.println("the sum is: " + a );

    }

    public void XXXSubtraction(int x, int y){
        a = x - y;
        System.out.println("the subtraction is: " + a );
    }
}

public class DemoExtend2 extends XXXCalculation{
    public void XXXMultiplication(int x, int y){
        a = x * y;
        System.out.println("the multiplication is: " + a );
    }


    public static void main(String[] args) {
        System.out.println("");
        int a= 10;
        int b= 20;

        DemoExtend2 yyy = new DemoExtend2();
        yyy.XXXAddition(a,b);
        yyy.XXXSubtraction(a,b);
        yyy.XXXMultiplication(a,b);


    }
}
