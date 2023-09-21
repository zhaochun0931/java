import java.io.*;


public class StudentSerialization implements java.io.Serializable{

    public String stu_name;
    public String stu_address;
    public int stu_id;


    public static void main(String[] args) {

        StudentSerialization s = new StudentSerialization();
        s.stu_name = "xiaoming";
        s.stu_address = "abc,xzy";
        s.stu_id = 1;

        try{
            FileOutputStream fileout = new FileOutputStream("s.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileout);

            out.writeObject(s);

            out.close();
            fileout.close();

            System.out.println("Object serialized and saved in s.txt");

        } catch (IOException ex){
            ex.printStackTrace();
        }

        }
}
