package exercise_20_04;

import java.util.Arrays;

public class Exercise_20_04 {

    public static void main(String[] args) {
        Point[] points = new Point[10];
        for(int i = 0; i < points.length; i++) {
            points[i] = new Point();
            points[i].setX(Math.random() * 100);
            points[i].setY(Math.random() * 100);
        }
        
        Arrays.sort(points);
        displayArray(points);
        
        Arrays.sort(points, new CompareY());
        displayArray(points);
    }
    
    public static void displayArray(Point[] points) {
        for(Point o : points) {
            System.out.print(o + " ");
        };
        System.out.println();
    }
}
