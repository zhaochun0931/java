import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StockPublisher publisher = new StockPublisher();
        Random random = new Random();

        // Add listener
        publisher.addListener(event -> {
            String time = new SimpleDateFormat("HH:mm:ss").format(new Date(event.getTimestamp()));
            System.out.println("[" + time + "] " + event.getSymbol() + " price: " + String.format("%.2f", event.getPrice()));
        });

        String symbol = "AAPL";
        double price = 150.0;

        // Simulate price change every 5 seconds
        while (true) {
            double change = (random.nextDouble() - 0.5) * 2; // -1.0 to +1.0
            price += change;
            price = Math.max(price, 0.01); // avoid negative price
            publisher.publishPrice(symbol, price);
            Thread.sleep(5000);
        }
    }
}

