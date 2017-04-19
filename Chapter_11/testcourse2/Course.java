package testcourse2;

import java.util.ArrayList;

public class Course {
    private String courseName;
    private ArrayList<String> students = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        students.add(student);
    }

    public String[] getStudents() {
        String[] s = new String[students.size()];
        return students.toArray(s);
    }

    public int getNumberOfStudents() {
        return students.size();
    }

    public String getCourseName() {
        return courseName;
    }

    public void dropStudent(String student) {
        students.remove(student);
    }
    
    public void clear(){
        students.clear();
    }
}