package view;

import model.Student;
import model.StudyGroup;

public class StudentView {
    public void printOnConsole(Student student){
        System.out.println(student);
    }
    public void printGroup(StudyGroup studyGroup){
        System.out.println("Группа: " + "Учитель - " + studyGroup.getTeacher() + ", Студенты - " + studyGroup.getStudentList());
    }

}
