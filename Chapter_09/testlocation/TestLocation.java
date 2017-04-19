package testlocation;

import java.util.Scanner;

public class TestLocation {

    public static void main(String[] args) {
        double[][] data = getData();
        Location location = locateLargest(data);
        System.out.printf("The location of the largest element is %.2f at (%d, %d)\n",
                          location.maxValue, location.row, location.column);
        
    }
    
    public static double[][] getData(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns in the array: ");
        int row = input.nextInt();
        int column = input.nextInt();
        System.out.println("Enter the array:");
        double[][] data = new double[row][column];
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data[i].length; j++){
                data[i][j] = input.nextDouble();
            }
        }
        return data;
    }
    
    public static Location locateLargest(double[][] a){
        return new Location(a);
    }
}

class Location{
    public int row;
    public int column;
    public double maxValue;
    
    Location(double[][] array){
        maxValue = array[0][0];
        row = 0;
        column = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(maxValue < array[i][j]){
                    maxValue = array[i][j];
                    row = i;
                    column = j;
                }
            }
        }
    }
}