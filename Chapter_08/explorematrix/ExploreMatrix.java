package explorematrix;
import java.util.Scanner;

public class ExploreMatrix {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size for the matrix: ");
        int size = input.nextInt();
        int[][] matrix = generateMatrix(size);
        displayMatrix(matrix);
        allZerosAndOnesInRow(matrix);
        allZerosAndOnesInColumn(matrix);
        allZerosAndOnesInMajorDiagonal(matrix);
        allZerosAndOnesInSubDiagonal(matrix);
    }
    
    public static int[][] generateMatrix(int size){
        int[][] matrix = new int[size][size];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = (int)(Math.random() * 2);
            }
        }
        return matrix;
    }
    
    public static void displayMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void allZerosAndOnesInRow(int[][] matrix){
        boolean noSame = true;
        for(int i = 0; i < matrix.length; i++){
            boolean all0 = true;
            boolean all1 = true;
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] != 0){
                    all0 = false;
                }
                if(matrix[i][j] != 1){
                    all1 = false;
                }
            }
            if(all0){
                System.out.println("All 0s on row " + i);
                noSame = false;
            }
            else if(all1){
                System.out.println("All 1s on row " + i);
                noSame = false;
            }
        }
        if(noSame){
            System.out.println("No same numbers on a row");
        }
    }
    
    public static void allZerosAndOnesInColumn(int[][] matrix){
        boolean noSame = true;
        for(int i = 0; i < matrix[0].length; i++){
            boolean all0 = true;
            boolean all1 = true;
            for(int j = 0; j < matrix.length; j++){
                if(matrix[j][i] != 0){
                    all0 = false;
                }
                if(matrix[j][i] != 1){
                    all1 = false;
                }
            }
            if(all0){
                System.out.println("All 0s on column " + i);
                noSame = false;
            }
            else if(all1){
                System.out.println("All 1s on column " + i);
                noSame = false;
            }
        }
        if(noSame){
            System.out.println("No same numbers on a column");
        }
    }
    
    public static void allZerosAndOnesInMajorDiagonal(int[][] matrix){
        boolean all0 = true;
        boolean all1 = true;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][i] != 0){
                all0 = false;
            }
            if(matrix[i][i] != 1){
                all1 = false;
            }
        }
        if(all0){
            System.out.println("All 0s on the major diagonal");
        }
        else if(all1){
            System.out.println("All 1s on the major diagonal");
        }
        else{
            System.out.println("No same numbers on the major diagonal");
        }
    }
    
    public static void allZerosAndOnesInSubDiagonal(int[][] matrix){
        boolean all0 = true;
        boolean all1 = true;
        for(int i = 0, j = matrix[0].length - 1; i < matrix.length || j >= 0; i++, j--){
            if(matrix[i][j] != 0){
                all0 = false;
            }
            if(matrix[i][j] != 1){
                all1 = false;
            }
        }
        if(all0){
            System.out.println("All 0s on the sub-diagonal");
        }
        else if(all1){
            System.out.println("All 1s on the sub-diagonal");
        }
        else{
            System.out.println("No same numbers on the sub-diagonal");
        }
    }
}
