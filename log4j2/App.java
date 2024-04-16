import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Hello world!
 *
 */
public class App
{

    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

	LOGGER.info("This is the INFO level log message!");
	LOGGER.error("This is the ERROR level log message!");
	LOGGER.trace("This is the TRACE level log message!");
	LOGGER.debug("This is the DEBUG level log message!");
	LOGGER.warn("This is the WARN level log message!");
	LOGGER.fatal("This is the FATAL level log message!");
    }
}
