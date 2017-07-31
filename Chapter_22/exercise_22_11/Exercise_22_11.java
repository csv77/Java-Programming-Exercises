package exercise_22_11;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_22_11 {

    public static void main(String[] args) {
        System.out.print("How many points are in the set? ");
        Scanner input = new Scanner(System.in);
        int numberOfPoints = input.nextInt();
        double[][] points = new double[numberOfPoints][2];
        System.out.print("Enter " + numberOfPoints + " points: ");
        
        for(int i = 0; i < numberOfPoints; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }
        
        ArrayList<MyPoint> list = getConvexHull(points);
        System.out.println("The convex hull is");
        for(MyPoint point : list) {
            System.out.print("(" + point.x + ", " + point.y + ") ");
        }
        System.out.println();
    }
    
    public static ArrayList<MyPoint> getConvexHull(double[][] s) {
        ArrayList<MyPoint> convexHull = new ArrayList<>();
        
        ArrayList<MyPoint> points = new ArrayList<>();
        for(int i = 0; i < s.length; i++) {
            points.add(new MyPoint(s[i][0], s[i][1]));
        }
        
        MyPoint p0 = points.get(0);
        for(MyPoint point : points) {
            if(p0.y < point.y) {
                p0 = point;
            }
            else if(p0.y == point.y && p0.y < point.y) {
                p0 = point;
            }
        }
        convexHull.add(p0);
        
        //set p0 as rightMostLowestPoint for every MyPoint in points
        for(MyPoint point : points) {
            point.setRightMostLowestPoint(p0);
        }
        
        
        
        return convexHull;
    }
    
    private static class MyPoint implements Comparable<MyPoint> {
        double x, y;
        MyPoint rightMostLowestPoint;

        public MyPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }
        
        public void setRightMostLowestPoint(MyPoint p) {
            this.rightMostLowestPoint = p;
        }
        
        public double getAngle() {
            return Math.atan2(rightMostLowestPoint.y - this.y, rightMostLowestPoint.x - this.x);
        }
        
        @Override
        public int compareTo(MyPoint o) {
            
            
        }
    }
}
