import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class SecureFileAccess {
    public static void main(String[] args) {
        System.out.println("Attempting to write a file...");
        String filePath = "/tmp/secured_file.txt"; // Use "C:\\Temp\\secured_file.txt" on Windows

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("This file was written successfully.");
            System.out.println("Success: File was written at " + filePath);
        } catch (SecurityException e) {
            System.out.println("Denied: A SecurityException was caught!");
            System.out.println("Error message: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("An IOException occurred: " + e.getMessage());
        }

        System.out.println("Demonstration finished.");
    }
}
