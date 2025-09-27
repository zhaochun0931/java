import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Create an object
        Person originalPerson = new Person("John Doe", 30, "secret-password");
        String filename = "person.ser";

        try {
            // Serialize the object
            Serializer.serialize(originalPerson, filename);
            System.out.println("Original object serialized: " + originalPerson);

            // Deserialize the object
            Person deserializedPerson = Serializer.deserialize(filename);
            System.out.println("Deserialized object: " + deserializedPerson);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
