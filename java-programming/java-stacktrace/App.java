public class App {
    public static void main(String[] args) {
        System.out.println("Before printing stack trace");
        printStackTrace();
        System.out.println("After printing stack trace");
    }

    public static void printStackTrace() {
        Thread.dumpStack();
    }
}
