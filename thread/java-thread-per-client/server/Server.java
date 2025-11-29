import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080...");

            while (true) {
                Socket client = serverSocket.accept();
                System.out.printf("New client connected: %s on thread %d%n",
                        client.getInetAddress(),
                        Thread.currentThread().getId());

                new Thread(new ClientHandler(client)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket client;

    public ClientHandler(Socket socket) {
        this.client = socket;
    }

    public void run() {
        long threadId = Thread.currentThread().getId();

        System.out.println("ClientHandler running on thread " + threadId);

        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true)
        ) {
            out.println("Welcome (thread " + threadId + ")");

            out.println("bye");  // immediate disconnect

            client.close();
            System.out.println("Client disconnected on thread " + threadId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

