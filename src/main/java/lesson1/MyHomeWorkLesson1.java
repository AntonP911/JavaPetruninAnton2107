package lesson1;

public class MyHomeWorkLesson1 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign() {
        int a = 12, b = -13;
        if (a + b > 0) System.out.println("Сумма положительная"); //т.к. одна строчка, то можно не использовать уродливые {}  :)
        else System.out.println("Сумма отрицательная");
    }

    public static void printColor() {
        int value = 101;
        if (value < 0) System.out.println("Красный");
        else if (value > 100) System.out.println("Зеленый");
        else System.out.println("Желтый");
    }

    public static void compareNumbers() {
        int a = 11, b = 5;
        if (a >= b) System.out.println("a >= b");
        else System.out.println("a < b");
    }
}
