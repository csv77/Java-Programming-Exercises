package testintersectingpoint;
import java.util.Scanner;
import testlinearequation.LinearEquation;
        
public class TestIntersectingPoint {

    public static void main(String[] args) {
        System.out.println("Enter the coordinates of 4 points: ");
        double[][] points = getPoints();
        double[] arg = getArguments(points);
        LinearEquation lin = new LinearEquation(arg[0], arg[1], arg[2], arg[3], arg[4], arg[5]);
        if(!lin.isSolvable()){
            System.out.println("There is no intersecting point, the lines are parallel");
        }
        else{
            System.out.printf("The coordinates of intersecting points are:\nx = %.3f, y = %.3f\n",
                              lin.getX(), lin.getY());
        }
    }
    
    public static double[][] getPoints(){
        double[][] points = new double[4][2];
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points[i].length; j++){
                points[i][j] = input.nextDouble();
            }
        }
        return points;
    }
    
    public static double[] getArguments(double[][] points){
        double[] p = new double[6];
        p[0] = points[0][1] - points[1][1];
        p[1] = - points[0][0] + points[1][0];
        p[2] = points[2][1] - points[3][1];
        p[3] = - points[2][0] + points[3][0];
        p[4] = p[0] * points[0][0] + p[1] * points[0][1];
        p[5] = p[3] * points[2][0] + p[4] * points[2][1];
        return p;
    }
    
}
