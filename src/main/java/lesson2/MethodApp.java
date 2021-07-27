package lesson2;

public class MethodApp {

    public static void main(String[] args) {
        System.out.println(checkSum(14,6));
        checkPositiveOrNegativeNumber(-1);
        System.out.println(checkPositiveOrNegativeNumberBool(0));
        writeLineMultiply("Тестовая строка", 5);
        System.out.println(checkYear(2000));
    }

    //Задание 1
    public static boolean checkSum(int a, int b) {
        int sum = a + b;
        return (sum >= 10) && (sum <= 20);
    }

    //Задание 2
    public static void checkPositiveOrNegativeNumber(int a) {
        if (a >= 0) {
            System.out.println("Число " + a + " положительное");
        } else {
            System.out.println("Число " + a + " отрицательное");
        }
    }

    //Задание 3
    public static boolean checkPositiveOrNegativeNumberBool(int a) {
        return (a < 0);
    }

    //Задание 4
    public static void writeLineMultiply(String str, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(str);
        }
    }

    //Задание 5
    public static boolean checkYear(int year) {
        return ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0)));
    }
}
