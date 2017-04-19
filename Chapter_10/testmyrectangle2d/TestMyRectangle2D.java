package testmyrectangle2d;

public class TestMyRectangle2D {

    public static void main(String[] args) {
        MyRectangle2D r1 = new MyRectangle2D(2, 2, 5.5, 4.9);
        System.out.println(r1.getArea() + " " + r1.getPerimeter());
        System.out.println(r1.contains(3, 3));
        System.out.println(r1.contains(new MyRectangle2D(2, 3, 1, 1)));
        System.out.println(r1.overlaps(new MyRectangle2D(2, 2, 3, 4)));
    }
    
}
