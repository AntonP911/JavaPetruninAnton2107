package Lesson5;

public class HomeWork5App {
    public static void main(String[] args) {
        dogClass bethovenDog = new dogClass("black", "Bethoven", 10, 50, false, true);
        bethovenDog.run(150);
        bethovenDog.swim(5);

        dogClass bobikDog = new dogClass("black", "bobik", 10, 50, true, true);
        bobikDog.run(750);
        bobikDog.swim(100);

        catClass catBarsik = new catClass("Orange","Barsik", 1,15, false,true);
        catBarsik.run(100);
        catBarsik.swim(15);

        System.out.println("Количество кошек " + catClass.getCount());
        System.out.println("Количество собак " + dogClass.getCount());
    }
}
