import java.io.*;

class Demo implements java.io.Serializable{
    public int a;
    public String b;

    public Demo(int a, String b){
        this.a = a;
        this.b = b;
    }

}

class DemoSerialization1{
    public static void main(String[] args) {
        Demo myobj = new Demo(1,"xiaoming");
        String myfilename = "file.txt";

//        Serialization

        try {
//            Saving of object in a file
            FileOutputStream fso = new FileOutputStream(myfilename);
            ObjectOutputStream oos = new ObjectOutputStream(fso);

//            Method for serialization of object
            oos.writeObject(myobj);
            oos.close();
            fso.close();

            System.out.println("Object has been serialized");

        }
        catch (IOException ex){
            System.out.println("IOException is caught");
        }


        Demo object1 = null;

//        Deserialization
        try {

//            Reading the object from a file
            FileInputStream fis = new FileInputStream(myfilename);
            ObjectInputStream ois = new ObjectInputStream(fis);

//            Method for deserialization of object
            object1 = (Demo) ois.readObject();
            ois.close();
            fis.close();

            System.out.println("Object has been deserialized");
            System.out.println("a = " + object1.a);
            System.out.println("b = " + object1.b);



        }

        catch (IOException ex) {
            System.out.println("IOException is caught");

        }

        catch (ClassNotFoundException ex){
            System.out.println("ClassNotFoundException is caught");
        }


    }
}

