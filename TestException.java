public class TestException {
    public static void main(String[] args) {
        try{
            int a = 10;
            int b = 0;
            int result = a / b;
            System.out.println("this is the try code block");
            System.out.println("division is " + result);
            System.out.println("rest of code in try block");
            System.out.println("");
            System.out.println("");

        }
        catch (ArithmeticException e){
            System.out.println("the is the exception code block");
            System.out.println("arithmetic exectpion=>" + e.getMessage());
            e.printStackTrace();
            System.out.println("");
            System.out.println("");

        }
        finally {
            System.out.println("this is the final code block");
            System.out.println("");
            System.out.println("");

        }
    }
}
