import java.rmi.Naming;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            CalculatorService calculatorService = (CalculatorService) Naming.lookup("//localhost/CalculatorService");
            int result = calculatorService.add(5, 3);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.err.println("CalculatorClient exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

