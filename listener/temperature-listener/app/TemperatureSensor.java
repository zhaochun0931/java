import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor {
    private final List<TemperatureChangeListener> listeners = new ArrayList<>();
    private int currentTemperature = 20;

    public void addListener(TemperatureChangeListener listener) {
        listeners.add(listener);
    }

    public void setTemperature(int newTemperature) {
        if (newTemperature != this.currentTemperature) {
            this.currentTemperature = newTemperature;
            // Notify all registered listeners
            for (TemperatureChangeListener listener : listeners) {
                listener.onTemperatureChange(newTemperature);
            }
        }
    }
}
