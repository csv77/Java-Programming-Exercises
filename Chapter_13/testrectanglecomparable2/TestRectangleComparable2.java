package testrectanglecomparable2;

public class TestRectangleComparable2 {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5, 10);
        Rectangle r2 = new Rectangle(25, 2);
        Rectangle r3 = new Rectangle(15, 10);
        System.out.println("r1 and r2 are equals? " + (r1.equals(r2) ? "yes" : "no"));
        System.out.println("r1 and r3 are equals? " + (r1.equals(r3) ? "yes" : "no"));
    }
}
