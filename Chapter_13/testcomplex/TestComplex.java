package testcomplex;

import java.util.Scanner;

public class TestComplex {

    public static void main(String[] args) {
        System.out.print("Enter the first complex number: ");
        Complex c1 = getComplex();
        System.out.print("Enter the second complex number: ");
        Complex c2 = getComplex();
        System.out.println(c1 + " + " + c2 + " = " + c1.add(c2));
        System.out.println(c1 + " - " + c2 + " = " + c1.subtract(c2));
        System.out.println(c1 + " * " + c2 + " = " + c1.multiply(c2));
        System.out.println(c1 + " / " + c2 + " = " + c1.divide(c2));
        System.out.println("|" + c1 + "|" + " = " + c1.abs());
    }
    
    public static Complex getComplex() {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();
        return new Complex(a, b);
    }
}
