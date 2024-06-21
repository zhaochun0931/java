import javax.net.ssl.*;
import java.io.*;
import java.security.*;

public class SSLServer {

    public static void main(String[] args) {
        int port = 8443;

        try {
            // Load the keystore
            char[] keystorePass = "password".toCharArray();
            char[] keyPass = "password".toCharArray();
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(new FileInputStream("server.p12"), keystorePass);

            // Initialize key manager factory
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(ks, keyPass);

            // Initialize SSL context
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), null, null);

            // Create SSL server socket factory
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();

            // Create SSL server socket
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);

            // Start accepting incoming connections
            System.out.println("SSL Server started on port " + port + "...");
            while (true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                System.out.println("Client connected: " + sslSocket.getInetAddress());

                // Handle client connection in a new thread
                new Thread(new ClientHandler(sslSocket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Client handler thread
    static class ClientHandler implements Runnable {
        private SSLSocket sslSocket;

        ClientHandler(SSLSocket sslSocket) {
            this.sslSocket = sslSocket;
        }

        @Override
        public void run() {
            try {
                // Start handshake
                sslSocket.startHandshake();

                // Read input from client
                BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received from client: " + line);
                }

                // Respond to client
                PrintWriter writer = new PrintWriter(sslSocket.getOutputStream(), true);
                writer.println("Hello, client!");

                // Close streams and socket
                reader.close();
                writer.close();
                sslSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
