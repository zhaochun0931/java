import java.io.Serializable;

public class Person implements Serializable {
    // It's highly recommended to declare a serialVersionUID for version control.
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private transient String password; // A transient field will not be serialized.

    public Person(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", age=" + age +
               ", password='" + password + '\'' +
               '}';
    }
}
