import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClassB {
    private static final Logger logger = LogManager.getLogger(ClassB.class);

    public void doSomethingElse() {
        logger.debug("DEBUG: ClassB debug message (should not appear, as log level is INFO)");
        logger.info("INFO: ClassB is processing data");
        logger.warn("WARN: ClassB encountered a minor issue");
        logger.error("ERROR: ClassB encountered a serious error");
    }
}
