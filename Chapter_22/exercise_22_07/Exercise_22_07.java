package exercise_22_07;

public class Exercise_22_07 {

    public static void main(String[] args) {
        Point[] points = new Point[5];
        points[0] = new Point(5, 5);
        points[1] = new Point(6, 6);
        points[2] = new Point(1, 2);
        points[3] = new Point(1, 9);
        points[4] = new Point(8, 7);
        
        Pair pair = Pair.getClosestPair(points);
        
        System.out.println(pair.getP1());
        System.out.println(pair.getP2());
        System.out.println(pair.getDistance());
    }
}
