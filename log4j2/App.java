import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class App
{

    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

	LOGGER.info("This is an INFO level log message!");
	LOGGER.error("This is an ERROR level log message!");
    }
}
