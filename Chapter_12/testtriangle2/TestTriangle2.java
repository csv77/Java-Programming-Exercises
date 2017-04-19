package testtriangle2;

import java.util.Scanner;
import testtriangle2.SimpleGeometricObject;

public class TestTriangle2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean correctData = true;
        while(correctData){
            System.out.println("Enter the 3 sides of a triangle: ");
            double a = input.nextDouble();
            double b = input.nextDouble();
            double c = input.nextDouble();
            try {
                Triangle triangle = new Triangle(a, b, c);
                correctData = false;
                System.out.println(triangle.toString());
            }
            catch (IllegalTriangleException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
}
