package exercise_22_09;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.geometry.Point2D;

public class Exercise_22_09 {

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
        
        ArrayList<Point2D> list = getConvexHull(points);
        System.out.println("The convex hull is");
        for(Point2D point : list) {
            System.out.print("(" + point.getX() + ", " + point.getY() + ") ");
        }
        System.out.println();
    }
    
    public static ArrayList<Point2D> getConvexHull(double[][] s) {
        ArrayList<Point2D> points = new ArrayList<>();
        for(int i = 0; i < s.length; i++) {
            points.add(new Point2D(s[i][0], s[i][1]));
        }
        
        ArrayList<Point2D> list = new ArrayList<>();
        
        Point2D h0 = points.get(0);
        for(Point2D point : points) {
            if(h0.getY() < point.getY()) {
                h0 = point;
            }
            else if(h0.getY() == point.getY() && h0.getX() < point.getX()) {
                h0 = point;
            }
        }
        list.add(h0);
        
        Point2D t0 = h0;
        Point2D t1 = points.get(0);
        while(t1 != h0) {
            if(t0 != points.get(0)) {
                t1 = points.get(0);
            }
            else {
                t1 = points.get(1);
            }
            
            for(Point2D point : points) {
                if(getPosition(t0, t1, point) > 0) {
                    t1 = point;
                }
            }
            
            if(t1 != h0) {
                list.add(t1);
                t0 = t1;
            }
        }
        return list;
    }
    
    public static double getPosition(Point2D p0, Point2D p1, Point2D p2) {
        return (p1.getX() - p0.getX()) * (p2.getY() - p0.getY()) -
                (p2.getX() - p0.getX()) * (p1.getY() - p0.getY());
    }
}
