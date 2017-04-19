package latinsquare;

import java.util.Scanner;

public class LatinSquare {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number n: ");
        int number = input.nextInt();
        char[][] matrix = initMatrix(number);
        if(isLatinRow(matrix) && isLatinColumn(matrix)){
            System.out.println("The input array is a Latin square");
        }
        else{
            System.out.println("The input array is not a Latin square");
        }
    }
    
    public static char[][] initMatrix(int number){
        char[][] m = new char[number][number];
        Scanner input = new Scanner(System.in);
        System.out.println("Enter " + number + " rows of letters separated by spaces: ");
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                String in = input.next();
                m[i][j] = in.charAt(0);
            }
            if(!correctChars(m[i])){
                System.out.println("Wrong input: the letters must be from A to " +
                                   (char)('A' + m.length - 1));
                System.exit(1);
            }
        }
        return m;
    }
    
    public static boolean correctChars(char[] chars){
        for(int i = 0; i < chars.length; i++){
            if(chars[i] < 'A' || chars[i] > 'A' + chars.length - 1){
                return false;
            }
        }
        return true;
    }
    
    public static boolean isLatinRow(char[][] m){
        for(int i = 0; i < m.length; i++){
            int[] counts = new int[m.length];
            for(int j = 0; j < m[i].length; j++){
                counts[m[i][j] - 65]++;
                if(counts[m[i][j] - 65] > 1){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isLatinColumn(char[][] m){
        for(int i = 0; i < m[0].length; i++){
            int[] counts = new int[m[i].length];
            for(int j = 0; j < m.length; j++){
                counts[m[j][i] - 65]++;
                if(counts[m[j][i] - 65] > 1){
                    return false;
                }
            }
        }
        return true;
    }
    
}
