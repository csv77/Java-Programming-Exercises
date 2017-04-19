package sumelementsbycolumn;
import java.util.Scanner;

public class SumElementsByColumn {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 4-by-4 matrix row by row:");
        double[][] matrix = new double[4][4];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = input.nextDouble();
            }
        }
        System.out.println("Sum of the elements in the major diagonal is " +
                           sumMajorDiagonal(matrix));
    }
    
    public static void printSumOfColumns(double[][] m){
        for(int i = 0; i < m[0].length; i++){
            System.out.println("Sum of the elements at column " + i +" is " +
                               sumColumn(m, i));
        }
    }
    
    public static double sumColumn(double[][] m, int columnIndex){
        double sum = 0;
        for(int i = 0; i < m.length; i++){
            sum += m[i][columnIndex];
        }
        return sum;
    }
    
    public static double sumMajorDiagonal(double[][] m){
        double sum = 0;
        for(int i = 0; i < m.length; i++){
            sum += m[i][i];
        }
        return sum;
    }
}
