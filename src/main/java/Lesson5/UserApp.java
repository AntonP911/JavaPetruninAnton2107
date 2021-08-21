package Lesson5;

public class UserApp {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Иванов", "Сергей", "Иванович", 70);
        employees[1] = new Employee("Колесник", "Иван", "Александрович", 35);
        employees[2] = new Employee("Мышинский", "Алексей", "Андреевич", 41);
        employees[3] = new Employee("Колесник", "Иван", "Александрович", 58,"Wolf4546gf@mail.ru", 45000.0, "Супер-уборщик");
        employees[4] = new Employee("Колесник", "Иван", "Александрович", 30, "koolix0092@yandex.ru", 70000.0, "Менеджер");
        for (int i = 0; i < 5; i++) {
            if (employees[i].getAge() > 40) {
                employees[i].writeInfo(); //
            }
        }
    }

}
