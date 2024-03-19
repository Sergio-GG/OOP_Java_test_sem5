package controller;

import model.Student;
import model.StudyGroup;
import model.Type;
import model.User;
import service.DataService;
import service.StudyGroupService;
import view.StudentView;

import java.util.List;

public class Controller {
    private final DataService service =  new DataService();

    private  final StudyGroupService studyGroupService = new StudyGroupService(service);
    private final StudentView view = new StudentView();
    public void createStudent (String firstName, String lastName, String middleName){
        service.create(firstName,lastName,middleName, Type.STUDENT);
    }
    public void createTeacher (String firstName, String lastName, String middleName){
        service.create(firstName,lastName,middleName, Type.TEACHER);
    }

    public void createGroup(String firstName, String lastName, String middleName){
        studyGroupService.createGroup(firstName, lastName, middleName);

    }
    public void getAllStudents(){
        List<Student> userList = service.getAllStudents();
        for (Student user: userList){
            view.printOnConsole(user);
        }
    }

    public void showGroups(){
        List<StudyGroup> studyGroups = studyGroupService.getStudyGroups();
        for ( StudyGroup sg: studyGroups) {
            view.printGroup(sg);
        }
    }


}
