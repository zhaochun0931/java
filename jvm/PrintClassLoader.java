import java.sql.DriverManager;
import java.util.ArrayList;

public class PrintClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {

        System.out.println("Platform ClassLoader: "
            + ClassLoader.getPlatformClassLoader());

        System.out.println("System ClassLoader: "
            + ClassLoader.getSystemClassLoader());

        System.out.println("ClassLoader of this class: "
            + PrintClassLoader.class.getClassLoader());

        System.out.println("ClassLoader of DriverManager: "
            + DriverManager.class.getClassLoader());

        System.out.println("ClassLoader of ArrayList: "
            + ArrayList.class.getClassLoader());
    }


    }
