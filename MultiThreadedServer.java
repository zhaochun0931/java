import java.io.*;
import java.net.*;

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
                    System.out.println("New client connected: " + clientSocket.getInetAddress());

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
            System.out.println("Received from client: " + clientMessage);

            // Process the message and send a response
            out.println("Hello from the server! You said: " + clientMessage);

        } catch (IOException e) {
            System.err.println("Error in communication with client: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
                System.out.println("Client connection closed.");
            } catch (IOException e) {
                System.err.println("Error closing client connection: " + e.getMessage());
            }
        }
    }
}
