class ClassA {
    int a;
    void print(){
        System.out.println("ClassA: this is " + a);

    }
}

class ClassB {
    int b;
    void print(){
        System.out.println("ClassB this is " + b);
    }

}

public class ClassDemo {
    public static void main(String[] args) {

        ClassA test1 = new ClassA();
        test1.a = 100;
        test1.print();


        ClassB test2 = new ClassB();
        test2.b = 200;
        test2.print();

    }
}
