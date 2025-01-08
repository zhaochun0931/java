import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MultiThreadedServer {

    public static void main(String[] args) {
        int port = 12345; // Server will listen on this port

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            // Continuously accept and handle client connections
            while (true) {
                try {
                    // Accept a client connection
                    Socket clientSocket = serverSocket.accept();
                    String timestamp = getCurrentTimestamp();
                    System.out.println("[" + timestamp + "] New client connected: " + clientSocket.getInetAddress());

                    // Create a new thread for handling the client
                    new ClientHandler(clientSocket).start();
                } catch (IOException e) {
                    System.err.println("Error handling client connection: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Error starting the server: " + e.getMessage());
        }
    }

    // Utility method to get current timestamp formatted
    public static String getCurrentTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
}

// ClientHandler is a thread that handles communication with a client
class ClientHandler extends Thread {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            // Read the message from the client
            String clientMessage = in.readLine();
            String timestamp = MultiThreadedServer.getCurrentTimestamp();
            System.out.println("[" + timestamp + "] Received from client: " + clientMessage);

            // Process the message and send a response
            out.println("Hello from the server! You said: " + clientMessage);

        } catch (IOException e) {
            String timestamp = MultiThreadedServer.getCurrentTimestamp();
            System.err.println("[" + timestamp + "] Error in communication with client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
                String timestamp = MultiThreadedServer.getCurrentTimestamp();
                System.out.println("[" + timestamp + "] Client connection closed.");
            } catch (IOException e) {
                String timestamp = MultiThreadedServer.getCurrentTimestamp();
                System.err.println("[" + timestamp + "] Error closing client connection: " + e.getMessage());
            }
        }
    }
}
