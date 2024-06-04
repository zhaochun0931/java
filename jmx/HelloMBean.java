import java.lang.management.ManagementFactory;
import javax.management.*;

public class HelloMBean implements HelloMBeanMXBean {
    private String message = "Hello, World!";

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void sayHello() {
        System.out.println(message);
    }

    public static void main(String[] args) throws Exception {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.example:type=Hello");

        HelloMBean mbean = new HelloMBean();
        mbs.registerMBean(mbean, name);

        System.out.println("HelloMBean is ready...");
        Thread.sleep(Long.MAX_VALUE);
    }
}
