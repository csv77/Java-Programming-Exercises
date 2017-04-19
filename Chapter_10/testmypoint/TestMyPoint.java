package testmypoint;

public class TestMyPoint {

    public static void main(String[] args) {
        MyPoint myPoint1 = new MyPoint();
        MyPoint myPoint2 = new MyPoint(10, 30.5);
        System.out.printf("(%3f, %3f)\n", myPoint1.getX(), myPoint1.getY());
        System.out.printf("(%3f, %3f)\n", myPoint2.getX(), myPoint2.getY());
        System.out.println(myPoint1.distance(myPoint2));
    }
    
}
