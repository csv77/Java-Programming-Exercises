package vertexform;

import java.util.Scanner;
import testrationalclass.Rational;

public class VertexForm {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Type the value of a-b-c:");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        Rational r1 = new Rational(- b, 2 * a);
        Rational r2 = new Rational((4 * a * c - (long)(Math.pow(b, 2))), 4 * a);
        System.out.println("h is " + r1 + " k is " + r2);
    }
    
}
