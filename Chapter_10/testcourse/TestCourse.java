package testcourse;

public class TestCourse {

    public static void main(String[] args) {
        Course course = new Course("Java programming");
        course.addStudent("Peter");
        course.addStudent("Susan");
        course.addStudent("Mary");
        System.out.println(course.getNumberOfStudents());
        course.dropStudent("John");
        course.dropStudent("Mary");
        for(String a : course.getStudents()){
            System.out.println(a + " ");
        }
        System.out.println(course.getNumberOfStudents());
    }
    
}
