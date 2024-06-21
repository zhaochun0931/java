import javax.net.ssl.*;
import java.io.*;

public class SSLClient {

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 8443;

        try {
            // Create SSL context
            SSLContext sslContext = SSLContext.getInstance("TLS");

            // Create trust manager that trusts all certificates (not recommended for production)
            TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }

                public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {
                }
            }};
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create SSL socket factory
            SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            // Create SSL socket
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(serverAddress, serverPort);

            // Start handshake
            sslSocket.startHandshake();

            // Send data to server
            PrintWriter writer = new PrintWriter(sslSocket.getOutputStream(), true);
            writer.println("Hello, server!");

            // Read response from server
            BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            String response = reader.readLine();
            System.out.println("Response from server: " + response);

            // Close streams and socket
            writer.close();
            reader.close();
            sslSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
