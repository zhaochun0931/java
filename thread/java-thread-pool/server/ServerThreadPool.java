import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.util.concurrent.*;

public class ServerThreadPool {
    private static final int PORT = 8080;

    // Thread pool: 10 worker threads
    private static final ExecutorService pool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Thread-Pool Server started on port " + PORT);

            while (true) {
                Socket client = serverSocket.accept();

                System.out.println(
                        "New client connected: " +
                        client.getInetAddress().getHostAddress() +
                        ":" + client.getPort() +
                        " at " + LocalDateTime.now()
                );

                // Submit task to thread pool
                pool.submit(new ClientHandler(client));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private final Socket client;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true)
        ) {

            out.println("Welcome! You are served by thread: " + Thread.currentThread().getName());

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(
                    "[" + LocalDateTime.now() + "] "
                    + "Client " + client.getPort()
                    + " -> " + line
                );

                if (line.equalsIgnoreCase("bye")) break;

                out.println("Echo: " + line);
            }

            System.out.println("Client " + client.getPort() + " disconnected.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

