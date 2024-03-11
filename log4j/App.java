import org.apache.log4j.Logger;

import java.io.*;
import java.sql.SQLException;
import java.util.*;


/**
 * Hello world!
 *
 */
public class App
{
	/* Get actual class name to be printed on */
   static Logger log = Logger.getLogger(App.class.getName());


    public static void main( String[] args ) throws IOException,SQLException
    {
        System.out.println( "Hello World!" );


      log.debug("Hello this is a debug message");
      log.info("Hello this is an info message");


    }
}
