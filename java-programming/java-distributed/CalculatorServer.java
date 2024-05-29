import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) {
        try {
            CalculatorService calculatorService = new CalculatorServiceImpl();
            LocateRegistry.createRegistry(1099); // Default RMI registry port
            Naming.rebind("//localhost/CalculatorService", calculatorService);
            System.out.println("CalculatorService is bound and ready for use.");
        } catch (Exception e) {
            System.err.println("CalculatorServer exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

