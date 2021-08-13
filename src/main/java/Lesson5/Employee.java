package Lesson5;

public class Employee {

    public static int userCount = 0;

    private int id;
    private String name;
    private String surename;
    private String middlename;
    private int age;
    private String email;
    private double salary;
    private String position;

    public String getFIO() {
        return getSurename() + " " + getName() + " " + getMiddlename();
    }

    public void setFIO(String surename, String name, String middlename) {
        setName(name);
        setSurename(surename);
        setMiddlename(middlename);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 17) {
            this.age = age;
        } else System.out.println("детей на работу не брать!!!");;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surename='" + surename + '\'' +
                ", middlename='" + middlename + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", position='" + position + '\'' +
                '}';
    }

    public void writeInfo () {
        System.out.println(this);
    }

    public Employee(String surename, String name, String middlename, int age, String email, Double salary, String position) {
        this.id = userCount++;
        this.name = name;
        this.age = age;
        this.email = email;
        this.surename = surename;
        this.middlename = middlename;
        this.salary = salary;
    }

    public Employee(String surename, String name, String middlename, int age) {
        this(surename, name, middlename, age, "writeemail", 0.0, "В распоряжении");
    }
}
