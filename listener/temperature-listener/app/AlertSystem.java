public class AlertSystem implements TemperatureChangeListener {
    @Override
    public void onTemperatureChange(int newTemperature) {
        System.out.println("ALERT! Temperature changed to: " + newTemperature + "°C");
    }
}
