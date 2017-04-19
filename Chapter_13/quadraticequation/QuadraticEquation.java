package quadraticequation;

import java.util.Scanner;
import testcomplex.Complex;

public class QuadraticEquation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Type the value of a-b-c:");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double disc = Math.pow(b, 2) - 4 * a * c;
        if(disc > 0) {
            System.out.printf("root1: %.4f, root2: %.4f\n", (- b - Math.sqrt(disc)) / (2 * a), (- b + Math.sqrt(disc)) / (2 * a));
        }
        else if(disc == 0) {
            System.out.printf("root: %.4f\n", (- b / (2 * a)));
        }
        else {
            Complex c1 = new Complex(- b / (2 * a), Math.sqrt(disc * (-1)) / (2 * a));
            Complex c2 = new Complex(- b / (2 * a), - Math.sqrt(disc * (-1)) / (2 * a));
            System.out.println("root1: " + c1 + " root2: " + c2);
        }
        
    }
    
}
