package Lesson5;

public abstract class AnimalClass {
    private double weight;
    private double height;
    private String color;
    private String name; //Кличка

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    AnimalClass (String color, String name, double weight, double height) {
        this.weight = weight;
        this.height = height;
        this.color = color;
        this.name = name;
    }

    AnimalClass (String color, double weight, double height) {
        this(color, "Unknown",weight,height);
    }

    AnimalClass (String color) {
        this(color, "Unknown",0,0);
    }

    AnimalClass () {
        this("Unknown", "Unknown",0,0);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight > 0) {
            this.weight = weight;
        }

    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height > 5) {
            this.height = height;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == ""){
            this.color = "black";
        } else {
            this.color = color;
        }
    }

    public abstract void run (int distance);

    public abstract void swim (int distance);
}
