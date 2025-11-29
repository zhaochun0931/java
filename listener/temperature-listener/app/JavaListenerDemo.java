public class JavaListenerDemo {
    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor();
        AlertSystem alert = new AlertSystem();

        // Register the listener
        sensor.addListener(alert);

        System.out.println("Setting temperature to 25°C");
        sensor.setTemperature(25); // This will trigger the listener

        System.out.println("Setting temperature again, no change this time.");
        sensor.setTemperature(25); // This will NOT trigger the listener
    }
}
