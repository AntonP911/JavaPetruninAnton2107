package lesson1;

public class VariableApp {
    public static void main (String[] args) {
        int a = 10;
        int b = 50;
        int c = a + b;

        String value = "Строка";
        System.out.println(++c + " " + value);
        method1();
    }

    public static void method1 () {
        System.out.println("lol");
    }
}
