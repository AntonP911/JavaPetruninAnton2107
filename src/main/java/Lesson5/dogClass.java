package Lesson5;

public class dogClass extends animalClass {
    public static int count;
    public static final double MAX_RUN_DISTANCE = 500;
    public static final double MAX_SWIM_DISTANCE = 10;
    private Boolean protecter; //Охранник?
    private Boolean liveHome; //Домашний?

    public static int getCount() {
        return count;
    }

    public Boolean getProtecter() {
        return protecter;
    }

    public void setProtecter(Boolean protecter) {
        this.protecter = protecter;
    }

    public Boolean getLiveHome() {
        return liveHome;
    }

    public void setLiveHome(Boolean liveHome) {
        this.liveHome = liveHome;
    }

    public dogClass (String color, String name, double weight, double height, Boolean protecter, Boolean liveHome) {
        super(color,name,weight,height);
        this.protecter = protecter;
        this.liveHome = liveHome;
        count++;
    }

    public dogClass (String color, String name, double weight, double height, Boolean protecter) {
        this(color,name,weight,height,protecter,false);
    }

    public dogClass (String color, String name, double weight, double height) {
        this(color,name,weight,height,false,false);
    }

    @Override
    public void run(int distance) {
        if (distance > MAX_RUN_DISTANCE) {
            System.out.println(super.getName() + " пробежал " + MAX_RUN_DISTANCE + " метров, а потом устал и остальные " + (distance - MAX_RUN_DISTANCE) + " бежать не стал. Хозяин по ворчал немного...");
        } else {
            System.out.println(super.getName() + " пробежал " + distance + " метров.");
        }

    }

    @Override
    public void swim(int distance) {
        if (distance > MAX_SWIM_DISTANCE) {
            System.out.println(super.getName() + " понял что плыть слишком далеко и отказался плыть " + distance + " метров. Хозяин ругаться не стал. :)");
        } else {
            System.out.println(super.getName() + " проплыл " + distance + " метров.");
        }

    }
}
