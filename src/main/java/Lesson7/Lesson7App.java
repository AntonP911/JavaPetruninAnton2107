package Lesson7;

public class Lesson7App {
    public static final int CATS_COUNT = 4;
    public static final int PLATES_COUNT = 2;

    public static void main(String[] args) {
        Plate[] plates = new Plate[PLATES_COUNT];
        for (int i = 0; i < PLATES_COUNT; i++) {
            switch (i) {
                case 0 -> plates[i] = new Plate("Хаки",180, 100);
                case 1 -> plates[i] = new Plate("Черная",80, 50);
                case 2 -> plates[i] = new Plate("Красная",130, (15 * i * 2));
                case 3 -> plates[i] = new Plate("Фиолетовая",40, 0);
                case 4 -> plates[i] = new Plate("Синяя",100, (15 * i));
                default -> plates[i] = new Plate(60, (10 * i));
            }
        }
        for (int i = 0; i < PLATES_COUNT; i++) {
            System.out.println(plates[i].about());
        }

        Cat[] cats = new Cat[CATS_COUNT];
        for (int i = 0; i < CATS_COUNT; i++) {
            switch (i) {
                case 0 -> cats[i] = new Cat("Барсик", 5, "Черно-белый");
                case 1 -> cats[i] = new Cat("Васька", 100, "Черный");
                case 2 -> cats[i] = new Cat("Форик", 30, "Белый");
                case 3 -> cats[i] = new Cat("Барон", 45, "Рыжый");
                default -> cats[i] = new Cat("Борис");
            }
        }

        for (int i = 0; i < CATS_COUNT; i++) {
            System.out.println(cats[i].about());
        }

        System.out.println("Начнем...");
        for (Cat cat: cats) { //Для каждого кота
            int j = 0;
            do {
                if (j >= PLATES_COUNT) break; //Если еще есть не проверенные тарелки
            } while (cat.eatFrom(plates[j++]) == 2); //Пока кот не наелся делаем обход по тарелкам
        }

        plates[1].putFood(100); //Положим в одну из тарелок 100 еды

        System.out.println("Начнем еще раз...");
        for (Cat cat: cats) { //Для каждого кота
            int j = 0;
            do {
                if (j >= PLATES_COUNT) break; //Если еще есть не проверенные тарелки
            } while (cat.eatFrom(plates[j++]) == 2); //Пока кот не наелся делаем обход по тарелкам
        }
    }

}
