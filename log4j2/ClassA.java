import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClassA {
    private static final Logger logger = LogManager.getLogger(ClassA.class);

    public void doSomething() {
        logger.debug("DEBUG: ClassA is running a debug process");
        logger.info("INFO: ClassA finished processing");
        logger.warn("WARN: ClassA encountered a warning");
        logger.error("ERROR: ClassA encountered an error");
    }
}
