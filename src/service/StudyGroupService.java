package service;

import model.Student;
import model.StudyGroup;
import model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class StudyGroupService {

    DataService dataService;

    List<StudyGroup> studyGroups;



    public StudyGroupService(DataService dataService) {
        this.dataService = dataService;
        this.studyGroups = new ArrayList<>();
    }

    public void createGroup(String firstName, String lastName, String middleName){
        studyGroups.add(new StudyGroup(dataService.getTeacher(firstName, lastName, middleName), dataService.getAllStudents()));
    }

    public List<StudyGroup> getStudyGroups(){
        return studyGroups;
    }

}
