package Lesson5;

public class catClass extends AnimalClass {
    public static int count;
    public static final double MAX_RUN_DISTANCE = 200;
    private Boolean skin; //Лысый кот?
    private Boolean wild; //Дикий кот? зрачек галаз палочка вертикальная

    public static int getCount() {
        return count;
    }

    public Boolean getWild() {
        return wild;
    }

    public void setWild(Boolean wild) {
        this.wild = wild;
    }

    public Boolean getSkin() {
        return skin;
    }

    public void setSkin(Boolean skin) {
        this.skin = skin;
    }

    public catClass(String color, String name, double weight, double height, Boolean skin, Boolean wild) {
        super(color,name,weight,height);
        this.wild = wild;
        this.skin = skin;
        count++;
    }

    public catClass(String color, String name, double weight, double height, Boolean wild) {
        this(color,name,weight,height,wild,false);
    }

    public catClass(String color, String name, double weight, double height) {
        this(color,name,weight,height,false,false);
    }

    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println(super.getName() + " пробежал " + MAX_RUN_DISTANCE + " метров, а потом устал и лег отдыхать, остальные " + (MAX_RUN_DISTANCE - distance) + " он пробежал после хорошего отдыха!");
        } else {
            System.out.println(super.getName() + " пробежал " + distance + " метров.");
        }

    }

    @Override
    public void swim(int distance) {
        System.out.println(super.getName() + " плавать не умеет");
    }
}
