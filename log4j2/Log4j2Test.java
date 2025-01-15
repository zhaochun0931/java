import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Test {

    // Create a Logger instance
    private static final Logger logger = LogManager.getLogger(Log4j2Test.class);

    public static void main(String[] args) {
        // Log various levels of messages
        logger.info("This is an INFO level message");
        logger.debug("This is a DEBUG level message");
        logger.warn("This is a WARN level message");
        logger.error("This is an ERROR level message");
        logger.fatal("This is a FATAL level message");

        // Simulate a condition for logging an exception
        try {
            throw new Exception("This is a simulated exception");
        } catch (Exception e) {
            logger.error("An exception occurred: ", e);
        }
    }
}
