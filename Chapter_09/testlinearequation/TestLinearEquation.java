package testlinearequation;
import java.util.Scanner;

public class TestLinearEquation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the parameters: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();
        LinearEquation linE = new LinearEquation(a, b, c, d, e, f);
        if(!linE.isSolvable()){
            System.out.println("The equation has no solution");
        }
        else{
            System.out.printf("The solutions are: x = %.3f, y = %.3f\n", linE.getX(), linE.getY());
        }
    }
}

