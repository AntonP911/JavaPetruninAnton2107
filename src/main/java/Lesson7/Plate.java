package Lesson7;

public class Plate extends Container {
    private static int count = 0;
    private String colour;

    Plate(String colour, int capacity, int quantity) {
        super(capacity, quantity);
        this.colour = colour;
    }

    Plate(int capacity, int quantity) {
        this("Белая", capacity, quantity);
        count++;
    }

    public String getColour() {
        return colour;
    }

    Plate() {
        this(100, 0);
    }

    @Override
    public void putFood(int foodQuantity) {
        if (foodQuantity <= 0) {
            System.out.println("В " + getColour() + " тарелку пытаемся положить ничего?");
        } else if (foodQuantity > getCapacity() || getCapacity() < getQuantity() + foodQuantity) {
            System.out.println("В " + getColour() + " тарелку не помещается " + foodQuantity + "еды, сейчас в тарелке " + getQuantity() + " еды, поэтому тарелку заполняем полностью, а остальные " + (foodQuantity - (getCapacity() - getQuantity())) + " еды выкидываем!");
        } else System.out.println("В " + getColour() + " тарелку поместили " + foodQuantity + "еды.");
        super.putFood(foodQuantity);
    }

    @Override
    public boolean removeFood(int foodQuantity) {
        boolean result = super.removeFood(foodQuantity);
        if (result) {
            System.out.println("Из " + getColour() + " было взято " + foodQuantity + "еды. :)");
        }  else System.out.println("Из " + getColour() + " тарелки не удалось взять " + foodQuantity + "еды. :(");
        return result;
    }

    public String about() {
        return "Тарелка " + getColour() + ", вместимость еды всего " + getCapacity() + ", еды сейчас " + getQuantity();
    }
}
