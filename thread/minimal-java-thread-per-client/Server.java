import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080...");

            while (true) {
                Socket clientSocket = serverSocket.accept();  // Waits for client
                System.out.println("New client connected: " + clientSocket.getInetAddress());

                // Create a new thread for every client
                new Thread(new ClientHandler(clientSocket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        String clientAddress = clientSocket.getInetAddress().getHostAddress();
        int clientPort = clientSocket.getPort();
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        System.out.println("Client connected from " + clientAddress + ":" + clientPort + " at " + timestamp);

        try (
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
            );
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        ) {

            out.println("Hello from server! Type 'bye' to exit.");

            String line;
            while ((line = in.readLine()) != null) {
                String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                System.out.println("[" + currentTime + "] Received from " + clientAddress + ":" + clientPort + " -> " + line);
                if (line.equalsIgnoreCase("bye")) {
                    break;
                }
                out.println("Server echo: " + line);
            }

            String disconnectTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            System.out.println("Client " + clientAddress + ":" + clientPort + " disconnected at " + disconnectTime);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
