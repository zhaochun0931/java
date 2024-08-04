import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NioExample {

    public static void main(String[] args) {
        String filePath = "example.txt";

        // Write to file
        writeFile(filePath, "Hello, NIO!");

        // Read from file
        String content = readFile(filePath);
        System.out.println("File content: " + content);
    }

    private static void writeFile(String filePath, String content) {
        try (FileChannel fileChannel = FileChannel.open(Paths.get(filePath), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.clear();
            buffer.put(content.getBytes());
            buffer.flip(); // Prepare the buffer for writing

            while (buffer.hasRemaining()) {
                fileChannel.write(buffer);
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (FileChannel fileChannel = FileChannel.open(Paths.get(filePath), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int bytesRead = fileChannel.read(buffer);

            while (bytesRead != -1) {
                buffer.flip(); // Prepare the buffer for reading
                while (buffer.hasRemaining()) {
                    sb.append((char) buffer.get());
                }
                buffer.clear(); // Clear the buffer for the next read
                bytesRead = fileChannel.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
