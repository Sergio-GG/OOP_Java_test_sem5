package service;

import model.Student;
import model.Teacher;
import model.Type;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class DataService {

    private List<User> userList;

    public DataService() {
        this.userList = new ArrayList<>();
    }

    public void create(String firstName, String lastName, String middleName, Type type){
        int id = getFreeId(type);
        if(Type.STUDENT == type){
            Student student = new Student(firstName, lastName, middleName, id);
            userList.add(student);
        }
        if(Type.TEACHER == type){
            Teacher teacher = new Teacher(firstName, lastName, middleName, id);
            userList.add(teacher);
        }
    }
    public User getUserById(Type type, int id){
        boolean itsStudent = Type.STUDENT == type;
        User currentUser = null;
        for (User user: userList) {
            if(user instanceof Teacher && !itsStudent && ((Teacher) user).getTeacherId() == id){
                currentUser = user;
            }
            if(user instanceof Student && itsStudent && ((Student) user).getStudentId() == id){
                currentUser = user;
            }

        }
        return currentUser;
    }

    public List<User> getAllUsers(){
        return userList;
    }

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        for (User user: userList){
            if(user instanceof Student){
                students.add((Student)user);
            }
        }
        return students;
    }
    private int getFreeId(Type type){
        boolean itsStudent = Type.STUDENT == type;
        int lastId = 1;
        for (User user: userList) {
            if(user instanceof Teacher && !itsStudent){
                lastId = ((Teacher) user).getTeacherId() + 1;
            }
            if(user instanceof Student && itsStudent){
                lastId = ((Student) user).getStudentId() + 1;
            }

        }
        return lastId;
    }
    public Teacher getTeacher(String firstName, String lastName, String middleName){
        for(User user: userList){
            if(user instanceof Teacher){
                if(user.getFirstName().equals(firstName) && user.getLastName().equals(lastName) && user.getMiddleName().equals(middleName)){
                    return (Teacher) user;
                }
            }
        }
        return new Teacher(firstName, lastName, middleName, getFreeId(Type.TEACHER));
    }
}
