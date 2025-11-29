import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StockPublisher {
    private final List<StockListener> listeners = new CopyOnWriteArrayList<>();
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void addListener(StockListener listener) {
        listeners.add(listener);
    }

    public void publishPrice(String symbol, double price) {
        StockEvent event = new StockEvent(symbol, price, System.currentTimeMillis());
        for (StockListener listener : listeners) {
            executor.submit(() -> listener.onPriceChange(event));
        }
    }

    public void shutdown() {
        executor.shutdown();
    }
}

