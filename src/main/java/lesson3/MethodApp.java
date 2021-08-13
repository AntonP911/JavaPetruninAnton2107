package lesson3;

import java.util.Arrays;

public class MethodApp {

    public static void main(String[] args) {
        System.out.println("Задание 1");
        int[] joinMass1 = new int[]{0, 0, 0, 0, 1, 0, 1, 1, 0, 1, 1};
        System.out.println(Arrays.toString(invertMassZeroToOneAndBack(joinMass1)));

        System.out.println("Задание 2");
        int[] joinMass2 = new int[100];
        System.out.println(Arrays.toString(fillMassInOrderFromOneToHundred(joinMass2)));

        System.out.println("Задание 3");
        int[] joinMass3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(multiplyOnTwoIfNumberLessThenSix(joinMass3)));

        System.out.println("Задание 4");
        fillMassDiagonalElementsInUnits(5);

        System.out.println("Задание 5");
        System.out.println(Arrays.toString(createMassAndFillValue(6, 15)));

        System.out.println("Задание 6");
        int[] joinMass6 = new int[]{0, 7, 4, 9, -1, 14, 2, 3, 0, 1};
        System.out.println(Arrays.toString(seekMaximumAndMinimumValueInMass(joinMass6)));

        System.out.println("Задание 7");
        int[] joinMass7 = new int[]{1, 3, 1, 2, 3, 4, 1, 1, 0, 14};
        System.out.println(checkBalance(joinMass7));

        System.out.println("Подготовка к заданию 8 ***");
        int[] joinMass8 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] joinMass9 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] joinMass10 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Задание 8 *** с использованием цикла While");
        System.out.println(Arrays.toString(moveAnArrayByTheNumberOfSteps(joinMass8, 1)));
        System.out.println("Задание 8 *** с использованием цикла For");
        System.out.println(Arrays.toString(moveAnArrayByTheNumberOfSteps2(joinMass9, 1)));
    }

    //Задание 1
    public static int[] invertMassZeroToOneAndBack(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            switch (mass[i]) {   //я сначала написал по старинке, но мне IDEA предложил заменить мою конструкцию на эту, эта удобнее :)
                case 0 -> mass[i] = 1;
                case 1 -> mass[i] = 0;
            }
        }
        return mass;
    }

    //Задание 2
    public static int[] fillMassInOrderFromOneToHundred(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            mass[i] = i + 1;
        }
        return mass;
    }

    //Задание 3
    public static int[] multiplyOnTwoIfNumberLessThenSix(int[] mass) {
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] < 6) {
                mass[i] = mass[i] * 2;
            }
        }
        return mass;
    }

    //Задание 4
    public static void fillMassDiagonalElementsInUnits(int size) {
        int[][] mass = new int[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(mass[i], 0);
            for (int j = 0; j < size; j++) {
                if ((i == j) || (i == size - 1 - j)) {
                    mass[i][j] = 1;
                }
            }
            System.out.println(Arrays.toString(mass[i]));
        }

    }

    //Задание 5
    public static int[] createMassAndFillValue(int len, int initialValue) {
        if (len < 0) {
            len = 0;
        }
        int[] mass = new int[len];
        Arrays.fill(mass, initialValue);
        return mass;
    }

    //Задание 6 *

    /**
     * В Задании сказано "найти в нем минимальный и максимальный элементы", значит на выходе функция должна передать
     * сразу и минимальный и максимальный элемент. Решил отдавать их одномерным массивом размером 2, где первый
     * элемент минимальное значение в массиве, а второй элемент это маскимальное значение
     * Хотя может быть я не правильно понял задание? :)
     **/
    public static int[] seekMaximumAndMinimumValueInMass(int[] mass) {
        int[] resultMass = new int[2];
        int maximumValue = 0, minimumValue = 0;
        for (int j : mass) { //foreach - мы еще не проходили, но по красивее выглядит :)
            if (j > maximumValue) {
                maximumValue = j;
            }
            if (j < minimumValue) {
                minimumValue = j;
            }
        }
        resultMass[0] = minimumValue;
        resultMass[1] = maximumValue;
        return resultMass;
    }

    //Задание 7 **

    /**
     * Вроде бы в задании не сказано, что мы ограничены лишь одним методом, поэтому сделал вспомогательный метод, который будет считать сумму левой и правой части в массиве
     **/
    public static int sumWithStartAndEndElementInMassive(int[] mass, int start, int end) {
        int result = 0;
        for (int i = start; (i < mass.length) & (i <= end); i++) {
            result = result + mass[i];
        }
        return result;
    }

    public static boolean checkBalance(int[] mass) {
        int i = 0;
        do { //Тут правильнее использовать цикл for, но надаел он, хочу через do while :)
            if (sumWithStartAndEndElementInMassive(mass, 0, i) == sumWithStartAndEndElementInMassive(mass, i + 1, mass.length - 1)) {
                return true;
            }
            i++;
        } while (i < mass.length);
        return false;
    }

    //Задание 8 *** с использованием цикла While
    public static int[] moveAnArrayByTheNumberOfSteps(int[] mass, int step) {
        int i = 0;
        while (i < (mass.length + step) % mass.length) {
            int j = mass.length - 1;
            int buffer = mass[j]; //Сохраним в переменную buffer последний элемент в массиве
            while (true) {
                if (j == 0) {
                    mass[j] = buffer; //Сохраним в первый элемент массива переменную buffer (бывший последний элемент из массива)
                    break; //Теперь массив прокручен на один шаг :)
                } else {
                    mass[j] = mass[j - 1]; //теперь текущий элемент массива равен предыдущему
                    j--;
                }
            }
            i++;
        }
        return mass;
    }

    //Задание 8 *** с использованием цикла For (в данном задании именно через for эту задачу делать уместнее)
    public static int[] moveAnArrayByTheNumberOfSteps2(int[] mass, int step) {
        for (int i = 0; i < (mass.length + step) % mass.length; i++) {
            int buffer = mass[mass.length - 1]; //Сохраним в переменную buffer последний элемент из массива
            for (int j = mass.length - 1; ; j--) { // бесконечный цикл
                if (j == 0) { //Условие выхода из бесконечного цикла
                    mass[j] = buffer; //Сохраним в первый элемент массива переменную buffer (бывший последний элемент из массива)
                    break; //Теперь массив прокручен на один шаг :)
                } else {
                    mass[j] = mass[j - 1];  //теперь текущий элемент массива равен предыдущему
                }
            }
        }
        return mass;
    }
}