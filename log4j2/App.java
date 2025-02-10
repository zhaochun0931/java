import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;

import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        // Load Log4j2 configuration from the XML file
        // Configurator.initialize(null, Paths.get("resources/log4j2.xml").toUri().toString());

        // Create instances of ClassA and ClassB
        ClassA classA = new ClassA();
        ClassB classB = new ClassB();

        // Call methods that generate logs
        classA.doSomething();
        classB.doSomethingElse();

        System.out.println("Logging completed. Check logs/classA.log and logs/classB.log");
    }
}
