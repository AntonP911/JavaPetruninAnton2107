package Lesson7;

public abstract class Container {
    private int capacity;
    private int quantity;

    Container(int capacity, int quantity) {
        this.capacity = capacity;
        this.quantity = quantity;
    }

    Container () {
        this(100, 0);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity < 0) this.capacity = 0;
        else if (capacity > getQuantity()) this.capacity = getQuantity();
        else this.capacity = capacity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void putFood(int foodQuantity) {
        if (getCapacity() < getQuantity() + foodQuantity) {
            setQuantity(getCapacity());
        } else {
            setQuantity(getQuantity() + foodQuantity);
        }
    }

    public boolean removeFood(int foodQuantity) {
        boolean result = false;
        if (getQuantity() >= foodQuantity) {
            setQuantity(getQuantity() - foodQuantity);
            result = true;
        }
        return result;
    }
}
