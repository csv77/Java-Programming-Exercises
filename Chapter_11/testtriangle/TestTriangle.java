package testtriangle;
import java.util.Scanner;

public class TestTriangle {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the sides of the triangle: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        System.out.println("color: ");
        String color = input.next();
        System.out.println("Is it filled (true/false)? ");
        boolean filled = input.nextBoolean();
        Triangle t1 = new Triangle(a, b, c);
        t1.setColor(color);
        t1.setFilled(filled);
        System.out.println("Area: " + t1.getArea() + "\nPerimeter: " + t1.getPerimeter() + 
                           "\ncolor: " + t1.getColor());
        System.out.println("Triangle is " + (t1.isFilled() ? "filled" : "not filled"));
    }
    
}
