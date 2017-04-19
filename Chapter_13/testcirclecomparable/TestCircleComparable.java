package testcirclecomparable;

public class TestCircleComparable {

    public static void main(String[] args) {
        Circle c1 = new Circle(5);
        Circle c2 = new Circle(12);
        Circle c3 = new Circle(5);
        System.out.println(c1.equals(c3));
        System.out.println(c1.equals(c2));
        
    }
    
}
