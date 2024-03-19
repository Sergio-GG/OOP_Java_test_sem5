import controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.createStudent("Иван", "Иванович", "Петров");
        controller.createStudent("Алексей","Алексеевич", "Высоков");
        controller.createTeacher("Владимир", "Всеславович", "Мощнов");
        controller.createGroup("Владимир", "Всеславович", "Мощнов");

        controller.getAllStudents();
        System.out.println("======================");
        controller.showGroups();
    }
}