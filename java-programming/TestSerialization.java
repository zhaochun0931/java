import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;


public class TestSerialization implements Serializable{

    private static final long serialVersionUID = 5887391604554532906L;
    private int id;
    private String name;

    public TestSerialization(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "test serialization id= " + id + " name= " + name;

    }

    @SuppressWarnings("reource")
    public static void main(String[] args) throws IOException, ClassNotFoundException{

        System.out.println("hello serialization");

//        serialization test
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("testSerialization.obj"));
        oos.writeObject("test serialization");
        oos.writeObject(618);
        TestSerialization test = new TestSerialization(1,"xiaoming");
        oos.writeObject(test);


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("testSerialization.obj"));
        System.out.println((String) ois.readObject());

        System.out.println((Integer)ois.readObject());

        System.out.println((TestSerialization)ois.readObject());



    }
}
