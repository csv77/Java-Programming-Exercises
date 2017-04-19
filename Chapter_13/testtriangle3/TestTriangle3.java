package testtriangle3;

import java.util.Scanner;

public class TestTriangle3 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the 3 sides of the triangle: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        System.out.print("Choose color: ");
        String color = input.next();
        System.out.print("Is it filled? (true/false): ");
        boolean filled = input.nextBoolean();
        Triangle triangle = new Triangle(a, b, c, color, filled);
        System.out.println(triangle.toString());
        System.out.printf("The area is: %.2f\n", triangle.getArea());
        System.out.printf("The perimeter is: %.2f\n", triangle.getPerimeter());
        System.out.println("The color is " + color + ", and it is filled: " + filled);
    }
}
