package testcourse;

public class Course {
    private String courseName;
    private String[] students = new String[1];
    private int numberOfStudents;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(String student) {
        if(numberOfStudents == students.length){
            String[] newStudents = new String[students.length + 1];
            for(int i = 0; i < students.length; i++){
                newStudents[i] = students[i];
            }
            students = newStudents;
        }
        students[numberOfStudents++] = student;
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

    public void dropStudent(String student) {
        int index = findStudent(student);
        if(index != -1){
            String[] newStudents = new String[students.length - 1];
            for(int i = 0, j = 0; i < numberOfStudents; i++){
                if(index != i){
                    newStudents[j] = students[i];
                    j++;
                }
            }
            students = newStudents;
            numberOfStudents--;
        }
        else{
            System.out.println("Student " + student + " cannot find in this course list");
        }
    }
    
    public void clear(){
        students = new String[1];
        numberOfStudents = 0;
    }
    
    private int findStudent(String student){
        for(int i  = 0; i < students.length; i++){
            if(students[i].equals(student)){
                return i;
            }
        }
        return -1;
    }
}