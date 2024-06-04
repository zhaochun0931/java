// Client.java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        try {
            Socket socket = new Socket("localhost", 1234);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message = "Hello, Server!";
            out.println(message);

            String response = in.readLine();
            System.out.println("Server response: " + response);
            Thread.sleep(10000);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
