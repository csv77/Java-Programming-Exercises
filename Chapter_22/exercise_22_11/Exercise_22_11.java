package exercise_22_11;

import java.util.ArrayList;
import java.util.Collections;
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
            System.out.print(point);
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
            else if(p0.y == point.y && p0.x < point.x) {
                p0 = point;
            }
        }
        convexHull.add(p0);
        
        for(MyPoint point : points) {
            point.setRightMostLowestPoint(p0);
        }
        
        points.remove(p0);
        Collections.sort(points);
        
        convexHull.add(points.get(0));
        convexHull.add(points.get(1));
        
        int i = 2;
        while(i < points.size()) {
            MyPoint t1 = convexHull.get(convexHull.size() - 1);
            MyPoint t2 = convexHull.get(convexHull.size() - 2);
            if(getPosition(t2, t1, points.get(i)) < 0) {
                convexHull.add(points.get(i));
                i++;
            }
            else {
                convexHull.remove(t1);
            }
        }
        
        return convexHull;
    }
    
    public static double getPosition(MyPoint p0, MyPoint p1, MyPoint p2) {
        return (p1.x - p0.x) * (p2.y - p0.y) - (p2.x - p0.x) * (p1.y - p0.y);
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
        
        public double getDistanceFromRightMostLowestPoint() {
            return Math.sqrt(Math.pow((this.x - rightMostLowestPoint.x), 2) +
                    Math.pow(this.y - rightMostLowestPoint.y, 2));
        }
        
        @Override
        public int compareTo(MyPoint o) {
            if(getAngle() < o.getAngle()) {
                return 1;
            }
            else if(getAngle() == o.getAngle() &&
                    getDistanceFromRightMostLowestPoint() > o.getDistanceFromRightMostLowestPoint()) {
                return 0;
            }
            else {
                return -1;
            }
        }
        
        @Override
        public String toString() {
            return "(" + x + ", " + y + ") ";
        }
    }
}
