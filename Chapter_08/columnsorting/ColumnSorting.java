package columnsorting;

import java.util.Scanner;

public class ColumnSorting {

    public static void main(String[] args) {
        double[][] matrix = new double[3][3];
        initMatrix(matrix);
        sortColumns(matrix);
        System.out.println("\nThe column-sorted array is");
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
    
    public static double[][] sortColumns(double[][] m){
        for(int k = 0; k < m[0].length; k++){
            for(int i = m.length - 1; i > 0; i--){
                for(int j = 0; j < i; j++){
                    if(m[j][k] > m[j + 1][k]){
                        double temp = m[j][k];
                        m[j][k] = m[j + 1][k];
                        m[j + 1][k] = temp;
                    }
                }
            }
        }
        return m;
    }
}
