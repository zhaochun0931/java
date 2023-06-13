public class TestException {
    public static void main(String[] args) {
        try{
            int a = 10;
            int b = 0;
            int c = 5;
            int result_1 = a / c;
            int result_2 = a / b;
            System.out.println("this is the try code block");
            System.out.println("division is " + result_1);
            System.out.println("division is " + result_2);
            System.out.println("rest of code in try block");
            System.out.println("");
            System.out.println("");

        }
        catch (Exception e){
            System.out.println("the is the exception code block");
            System.out.println("exception ====>" + e.getMessage());
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
