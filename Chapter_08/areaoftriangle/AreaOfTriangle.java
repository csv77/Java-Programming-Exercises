package areaoftriangle;

import java.util.Scanner;

public class AreaOfTriangle {

    public static void main(String[] args) {
        double[][] points = new double[3][2];
        initPoints(points);
        if(getTriangleArea(points) == 0){
            System.out.println("The three points are on the same line");
        }
        else{
            System.out.printf("The area of the triangle is %4.2f\n", getTriangleArea(points));
        }
    }
    
    public static void initPoints(double[][] m){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter x1, y1, x2, y2, x3, y3: ");
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                m[i][j] = input.nextDouble();
            }
        }
    }
    
    public static double getTriangleArea(double[][] points){
        if(isOnLine(points)){
            return 0;
        }
        double x0 = points[0][0], y0 = points[0][1],
               x1 = points[1][0], y1 = points[1][1],
               x2 = points[2][0], y2 = points[2][1];
        double a = Math.sqrt(Math.pow(y1 - y0, 2) + Math.pow(x1 - x0, 2));
        double b = Math.sqrt(Math.pow(y2 - y0, 2) + Math.pow(x2 - x0, 2));
        double c = Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    
    public static boolean isOnLine(double[][] points){
        double x0 = points[0][0], y0 = points[0][1],
               x1 = points[1][0], y1 = points[1][1],
               x2 = points[2][0], y2 = points[2][1];
        if((x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) == 0){
            return true;
        }
        else{
            return false;
        }
    }
    
}
