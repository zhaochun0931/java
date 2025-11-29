import java.io.*;
import java.net.*;

public class SingleClient {
    public static void runClient(int id) {
        try {
            Socket s = new Socket("server", 8080);
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));

            System.out.println("Client " + id + " connected → " + in.readLine());

            s.close();

        } catch (Exception e) {
            System.out.println("Client " + id + " error: " + e.getMessage());
        }
    }
}

