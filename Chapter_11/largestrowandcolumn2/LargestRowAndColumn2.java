package largestrowandcolumn2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LargestRowAndColumn2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the array size n: ");
        int n = input.nextInt();
        int[][] matrix = new int[n][n];
        initMatrix(matrix);
        displayMatrix(matrix);
        ArrayList<Integer> list = largestRow(matrix);
        System.out.println("The largest row index: " + list.toString());
        list = largestColumn(matrix);
        System.out.println("The largest column index: " + list.toString());
    }

    public static void initMatrix(int[][] matrix) {
        for (int[] matrix1 : matrix) {
            for (int j = 0; j < matrix1.length; j++) {
                matrix1[j] = (int)(Math.random() * 2);
            }
        }
    }

    public static void displayMatrix(int[][] matrix) {
        System.out.println("The random matrix is:");
        for(int i = 0; i < matrix[0].length; i++){
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static int findMax(int[] matrix){
        int max = matrix[0];
        for (int i = 0; i < matrix.length; i++) {
            if(max < matrix[i]){
                max = matrix[i];
            }
        }
        return max;
    }
    
    public static ArrayList<Integer> largestRow(int[][] matrix){
        ArrayList<Integer> list = new ArrayList<>();
        int[] count = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 1){
                    count[i]++;
                }
            }
        }
        int max = findMax(count);
        getAllIndex(count, max, list);
        return list;
    }
    
    public static ArrayList<Integer> largestColumn(int[][] matrix){
        ArrayList<Integer> list = new ArrayList<>();
        int[] count = new int[matrix[0].length];
        for(int i = 0; i < matrix[0].length; i++){
            for(int j = 0; j < matrix.length; j++){
                if(matrix[j][i] == 1){
                    count[i]++;
                }
            }
        }
        int max = findMax(count);
        getAllIndex(count, max, list);
        return list;
    }
    
    public static void getAllIndex(int[] count, int max, ArrayList<Integer> list){
        for(int i = 0; i < count.length; i++){
            if(count[i] == max){
                list.add(i);
            }
        }
    }
    
}
