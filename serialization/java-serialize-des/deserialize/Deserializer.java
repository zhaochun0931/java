import java.io.ObjectInputStream;
import java.net.Socket;

public class Deserializer {
    public static void main(String[] args) throws Exception {
        String host = "serializer";
        int port = 9000;

        Socket socket = new Socket(host, port);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        Person person = (Person) in.readObject();
        System.out.println("Deserialized object received: " + person);

        in.close();
        socket.close();
    }
}

