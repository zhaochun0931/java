import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BatchClient {

    public static void main(String[] args) {
        // Define the server address and port to connect to
        String serverAddress = "localhost";  // Can also use the server IP address
        int port = 12345; // Port to connect to
        int numberOfClients = 5;  // Number of clients to connect in batch

        // Create and start multiple threads representing the clients
        for (int i = 0; i < numberOfClients; i++) {
            int clientId = i + 1;  // Unique client ID for identifying each client
            new Thread(new ClientTask(serverAddress, port, clientId)).start();
        }
    }
}

// ClientTask is a runnable that represents each client
class ClientTask implements Runnable {
    private String serverAddress;
    private int port;
    private int clientId;

    public ClientTask(String serverAddress, int port, int clientId) {
        this.serverAddress = serverAddress;
        this.port = port;
        this.clientId = clientId;
    }

    @Override
    public void run() {
        try (Socket socket = new Socket(serverAddress, port)) {
            // Get current timestamp in a readable format
            String timestamp = getCurrentTimestamp();
            System.out.println("[" + timestamp + "] Client " + clientId + " connected to the server.");

            // Sleep for 10 seconds after connection
            System.out.println("[" + getCurrentTimestamp() + "] Client " + clientId + " sleeping for 10 seconds...");
            Thread.sleep(10000); // Sleep for 10 seconds

            // Create input and output streams to communicate with the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a message to the server
            String message = "Hello from Client " + clientId;
            out.println(message);
            System.out.println("[" + getCurrentTimestamp() + "] Client " + clientId + " sent: " + message);

            // Read the server's response
            String serverResponse = in.readLine();
            System.out.println("[" + getCurrentTimestamp() + "] Client " + clientId + " received: " + serverResponse);

            // Client disconnects
            System.out.println("[" + getCurrentTimestamp() + "] Client " + clientId + " disconnected from the server.");

        } catch (IOException | InterruptedException e) {
            System.err.println("Error in Client " + clientId + ": " + e.getMessage());
        }
    }

    // Utility method to get current timestamp formatted
    private String getCurrentTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}
