import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serializer {
    public static void main(String[] args) throws Exception {
        Person person = new Person("Alice", 25, "secret123");

        try (ServerSocket server = new ServerSocket(9000)) {
            System.out.println("Serializer waiting for connection...");
            Socket client = server.accept();
            System.out.println("Deserializer connected: " + client.getInetAddress());

            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            out.writeObject(person);
            out.flush();

            System.out.println("Serialized object sent: " + person);
        }
    }
}

