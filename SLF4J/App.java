import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        // Replace 'fatal' with 'error'
        logger.error("This is a fatal error message"); // Correct method in SLF4J

        // Optionally, you can log exceptions with a stack trace
        try {
            throw new Exception("Example exception");
        } catch (Exception e) {
            logger.error("An exception occurred", e); // Log the exception with the stack trace
        }
    }
}
