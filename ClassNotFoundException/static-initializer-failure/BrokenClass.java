public class BrokenClass {
    static {
        int x = 1 / 0;   // Causes ArithmeticException during class loading
    }

    public static void test() {
        System.out.println("test");
    }
}

