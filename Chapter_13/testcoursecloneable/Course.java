package testcoursecloneable;

import java.util.Arrays;

public class Course implements Cloneable{
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }  

    public String getCourseName() {
        return courseName;
    }
    
    @Override
    public String toString() {
        return "\ncoursename: " + getCourseName() + "\nnumber of students: " + getNumberOfStudents() +
                "\nstudents: " + Arrays.toString(students);
    }

    @Override
    public Object clone() {
        try {
            Course courseClone = (Course)super.clone();
            courseClone.students = students.clone();
            return courseClone;
        }
        catch(CloneNotSupportedException ex) {
            System.out.println("Clone not supported exception!");
            return null;
        }
    }
}