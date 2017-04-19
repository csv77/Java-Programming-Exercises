package testrectanglecomparable;

public class TestRectangleComparable {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 5);
        Rectangle r2 = new Rectangle(15, 5);
        Circle c1 = new Circle(5);
        Circle c2 = new Circle(3);
        System.out.println(Rectangle.max(r1, r2));
        System.out.println(Circle.max(c1, c2));
        GeometricObject[] array = {new Circle(20), new Circle(10), new Rectangle(5, 10), new Rectangle(10, 10)};
        System.out.println("The total area is: " + sumArea(array));
        
    }
    public static double sumArea(GeometricObject[] a) {
        double sumArea = 0;
        for(int i = 0; i < a.length; i++) {
            sumArea += a[i].getArea();
        }
        return sumArea;
    }
}
