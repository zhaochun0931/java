import org.apache.log4j.Logger;

public class Log4jTest {

    // Initialize the logger
    private static final Logger logger = Logger.getLogger(Log4jTest.class);

    public static void main(String[] args) {
        // Log a message at different levels
        logger.debug("This is a DEBUG message");
        logger.info("This is an INFO message");
        logger.warn("This is a WARN message");
        logger.error("This is an ERROR message");
        logger.fatal("This is a FATAL message");

        // Simulate some application logic
        for (int i = 0; i < 5; i++) {
            logger.info("Logging some info message " + i);
        }

        logger.info("Log4jTest completed.");
    }
}
