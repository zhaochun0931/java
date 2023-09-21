import java.io.*;
import java.io.Serializable;


public class StudentDeserialization implements Serializable {

    String stu_name;
    String stu_address;

    int stu_id;


    public static void main(String[] args) {

        StudentDeserialization s = new StudentDeserialization();
        s.stu_name = "xiaoming";
        s.stu_address = "shanghai";
        s.stu_id = 10;

        try {
            FileOutputStream fileout = new FileOutputStream("student.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileout);
            out.writeObject(s);
            out.close();
            fileout.close();
            System.out.println("Object serialized and saved in student.txt");

            FileInputStream filein = new FileInputStream("student.txt");
            ObjectInputStream in = new ObjectInputStream(filein);
            s = (StudentDeserialization) in.readObject();
            in.close();
            filein.close();

        }catch (IOException ex){
            ex.printStackTrace();

        }catch(ClassNotFoundException c){
            System.out.println("student class not found");
            c.printStackTrace();
            return;

        }

        System.out.println("Deserialized student");
        System.out.println("name: " + s.stu_name);
        System.out.println("address: " + s.stu_address);
        System.out.println("number: " + s.stu_id);
    }
}
