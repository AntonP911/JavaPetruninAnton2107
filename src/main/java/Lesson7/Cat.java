package Lesson7;

public class Cat {
    private static int count = 0;
    private String name;
    private int hunger;
    private String colour;
    private Boolean Satiety;

    public Boolean getSatiety() {
        Satiety = getHunger() >= 10;
        return Satiety;
    }

    public Cat(String name, int hunger, String colour) {
        this.name = name;
        this.hunger = hunger;
        this.colour = colour;
        count++;
    }

    public Cat (String name) {
        this(name, 30, "Черный");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        if (hunger < 0) {
            this.hunger = 0;
        } else this.hunger = hunger;

    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String about() {
        return getColour() + " кот " + getName() + ", степень голода " + getHunger() + ", голоден ? " + getSatiety();
    }

    /**
     *
     * @param plate
     * @return 1 - значит успешно поел, 2 - значит кушать хочет, но на тарелке мало еды и кот не стал есть, 3 - значит кот не голоден и не стал есть
     */
    public int eatFrom(Plate plate) {
        int result;
        if (getSatiety()) {
            if (plate.getQuantity() >= getHunger()) {
                System.out.print(getColour() + " кот " + getName() + " подошел к " + plate.getColour() + " тарелке, покушал. ");
                plate.removeFood(getHunger());
                System.out.println("на " + plate.getColour() + " тарелке, осталось " + plate.getQuantity() + " еды.");
                result = 1;
            } else {
                System.out.print(getColour() + " кот " + getName() + " подошел к " + plate.getColour() + " тарелке, но еды оказалось недостаточно, ");
                System.out.println("ему надо " + getHunger() + " еды, а в " + plate.getColour() + " тарелке " + plate.getQuantity() + " еды, пошел искать дальше.");
                result = 2;
            }
        } else {
            System.out.println(getColour() + " кот " + getName() + " подошел к " + plate.getColour() + " тарелке, но понял что не голоден и пошел дальше.");
            result = 3;
        }
        return result;
    }
}
