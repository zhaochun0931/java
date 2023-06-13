public class TestException {
    public static void main(String[] args) {
        try{
            int divideByZero = 6 / 0;
            System.out.println("division is " + divideByZero);
            System.out.println("rest of code in try block");

        }
        catch (ArithmeticException e){
            System.out.println("arithmetic exectpion=>" + e.getMessage());
        }
        finally {
            System.out.println("this is the final block");
        }
    }
}
