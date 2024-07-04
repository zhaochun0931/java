import java.io.*;

// Serializable class
class Employee implements Serializable {
    private static final long serialVersionUID = 1L; // Version UID for serialization

    private int id;
    private String name;
    private transient double salary; // transient field won't be serialized

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        // Create an Employee object
        Employee emp = new Employee(1, "John Doe", 50000.0);

        // Serialization
        String filename = "employee.ser";
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(emp);
            System.out.println("Serialized data is saved in " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        Employee empFromFile = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            empFromFile = (Employee) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Print deserialized object
        if (empFromFile != null) {
            System.out.println("Deserialized Employee:");
            System.out.println(empFromFile);
        }
    }
}
