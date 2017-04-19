package testquadraticequation;
import java.util.Scanner;

public class TestQuadraticEquation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Type the value of a-b-c:");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        QuadraticEquation qe = new QuadraticEquation(a, b, c);
        System.out.print("The equation has ");
        if(qe.getDiscriminant() < 0){
            System.out.println("no real roots");
        }
        else if(qe.getDiscriminant() == 0){
            System.out.printf("one root: %.2f\n", (qe.getRoot1() > 0 ? qe.getRoot1() : qe.getRoot2()));
        }
        else{
            System.out.printf("two roots: %.2f and %.2f\n", qe.getRoot1(), qe.getRoot2());
        }
    }
}

class QuadraticEquation{
    private double a;
    private double b;
    private double c;
    
    QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }
    public double getC(){
        return c;
    }
    public double getDiscriminant(){
        return Math.pow(b, 2) - 4 * a * c;
    }
    public double getRoot1(){
        if(this.getDiscriminant() < 0){
            return 0;
        }
        else{
            return (-b + Math.sqrt(this.getDiscriminant())) / (2 * a);
        }
    }
    public double getRoot2(){
        if(this.getDiscriminant() < 0){
            return 0;
        }
        else{
            return (-b - Math.sqrt(this.getDiscriminant())) / (2 * a);
        }
    }
}