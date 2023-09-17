class Animal{
    String name;

    public void eat() {
        System.out.println("I can eat");
    }
}

class Dog extends Animal{

    public void display() {
        System.out.println("My name is " + name);
    }
}
public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println("");

        Dog xxx = new Dog();
        xxx.name = "xiaoming";
        xxx.display();
        xxx.eat();
    }
}
