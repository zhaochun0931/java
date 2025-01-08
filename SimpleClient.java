import java.io.*;
import java.net.*;

public class SimpleClient {

    public static void main(String[] args) {
        // Define the server address and port to connect to
        String serverAddress = "localhost";  // Can also use the server IP address
        int port = 12345;

        try (Socket socket = new Socket(serverAddress, port)) {
            // Notify the user that the client has connected to the server
            System.out.println("Connected to the server at " + serverAddress + ":" + port);

            // Sleep for 10 seconds after the connection is established
            System.out.println("Sleeping for 10 seconds...");
            Thread.sleep(10000); // Sleep for 10 seconds

            // After sleeping, create input and output streams to communicate with the server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a message to the server after the sleep period
            String message = "Hello, Server!";
            out.println(message);
            System.out.println("Sent to server: " + message);

            // Read the server's response
            String serverResponse = in.readLine();
            System.out.println("Received from server: " + serverResponse);

        } catch (IOException | InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
