package weeklyhours;
import java.util.Scanner;

public class WeeklyHours {

    public static void main(String[] args) {
        int[][] work = {{2,4,3,4,5,8,8},
                        {7,3,4,3,3,4,4},
                        {3,3,4,3,3,2,2},
                        {9,3,4,7,3,4,1},
                        {3,5,4,3,6,3,8},
                        {3,4,4,6,3,4,4},
                        {3,7,4,8,3,8,4},
                        {6,3,5,9,2,7,9}};
        int[][] order = sumInRows(work);
        printMatrix(order);
        sortMatrix(order);
        printMatrix(order);
    }
    
    public static int[][] sumInRows(int[][] w){
        int[][] o = new int[w.length][2];
        for(int i = 0; i < w.length; i++){
            for(int j = 0; j < w[i].length; j++){
                o[i][1] += w[i][j];
            }
            o[i][0] = i;
        }
        return o;
    }
    
    public static void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            System.out.print("Employee " + matrix[i][0] + " total hours: " + matrix[i][1]);
            System.out.println();
        }
    }
    
    public static void sortMatrix(int[][] matrix){
        for(int i = matrix.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(matrix[j][1] < matrix[j+1][1]){
                    int temp = matrix[j][1];
                    matrix[j][1] = matrix[j+1][1];
                    matrix[j+1][1] = temp;
                    temp = matrix[j][0];
                    matrix[j][0] = matrix[j+1][0];
                    matrix[j+1][0] = temp;
                }
            }
        }
    }
}
