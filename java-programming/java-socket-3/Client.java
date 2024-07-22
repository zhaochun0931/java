import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.OutputStream;


public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("HELLO".getBytes());
            System.out.println("Writing to server..");
            //Here we are writing again.
            outputStream.write("HI".getBytes());
            System.out.println("Writing to server again..");
            System.out.println("Closing client.");
            outputStream.close();
            socket.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
