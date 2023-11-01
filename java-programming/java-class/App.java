class xxx{
    int a;
    void print(){
        System.out.println("this is " + a);

    }
}

class yyy{
    int b;
    void print(){
        System.out.println("this is " + b);
    }

}

public class App {
    public static void main(String[] args) {

        xxx test1 = new xxx();
        test1.a = 100;
        test1.print();


        yyy test2 = new yyy();
        test2.b = 200;
        test2.print();

    }
}
