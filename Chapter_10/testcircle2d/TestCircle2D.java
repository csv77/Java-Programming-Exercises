package testcircle2d;

public class TestCircle2D {

    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(2, 2, 5.5);
        System.out.printf("The area of c1 is %.2f, the perimeter of it is %.2f\n", c1.getArea(), c1.getPerimeter());
        System.out.println(c1.contains(3, 3));
        System.out.println(c1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println(c1.overlaps(new Circle2D(3, 5, 2.3)));
    }
    
}
