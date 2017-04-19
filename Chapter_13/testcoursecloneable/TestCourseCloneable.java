package testcoursecloneable;

public class TestCourseCloneable {

    public static void main(String[] args) {
        Course c1 = new Course("Math");
        c1.addStudent("Peter");
        c1.addStudent("Susan");
        c1.addStudent("Jessica");
        Course c2 = (Course)c1.clone();
        System.out.println(c1);
        System.out.println(c2);
    }
    
}
