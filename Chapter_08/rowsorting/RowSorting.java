package rowsorting;
import java.util.Scanner;

public class RowSorting {

    public static void main(String[] args) {
        double[][] matrix = new double[3][3];
        initMatrix(matrix);
        sortRows(matrix);
        System.out.println("The row-sorted array is");
        displayMatrix(matrix);
    }
    
    public static void initMatrix(double[][] m){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a 3-by-3 matrix row by row:");
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                m[i][j] = input.nextDouble();
            }
        }
    }
    
    public static void displayMatrix(double[][] m){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static double[][] sortRows(double[][] m){
        for(int i = 0; i < m.length; i++){
            sortOneRow(m[i]);
        }
        return m;
    }
    
    public static void sortOneRow(double[] m){
        for(int i = m.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(m[j] > m[j + 1]){
                    double temp = m[j];
                    m[j] = m[j + 1];
                    m[j + 1] = temp;
                }
            }
        }
        
    }
    
}
