

public class student {

    String name;
    int age;

    public student(){

    }

    public student(String name, int age){
        this.name = name;
        this.age = age;

    }

    public void myintro(){
        System.out.println("hello my name is " + name + " and I am " + age + " years old.");
    }


    public static void main(String[] args) {
        System.out.println("java class demo");

        student test1 = new student();
        test1.name = "xiaoming";
        test1.age = 10;
        test1.myintro();


        student test2 = new student("xiaogang", 20);
        test2.myintro();

    }

}
