package multiplymatrices;

public class MultiplyMatrices {

    public static void main(String[] args) {
        double[][] x = {{1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12}};
        double[][] y = {{0,2.0,4.0},
                        {1,4.5,2.2},
                        {1.1,4.3,5.2},
                        {2,3,5}};
        if(x[0].length != y.length){
            System.out.println("Cannot multiply this 2 matrices!");
        }
        else{
            double[][] z = multiplyMatrix(x,y);
            printMultiply(x, y, z);
            //printMatrix(z);
        }
        
    }
    
    public static double[][] multiplyMatrix(double[][] a, double[][] b){
        double[][] c = new double[a.length][b[0].length];
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b[0].length; j++){
                for(int k = 0; k < a[0].length; k++){
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        
        return c;
    }
    
    public static void printMatrix(double[][] a){
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                System.out.printf("%4.1f ", a[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void printMultiply(double[][] a, double[][] b, double[][] c){
        for(int i = 0; i < a.length || i < b.length; i++){    
            if(i == a.length / 2){
                if(i < a.length){
                    for(int j = 0; j < a[i].length; j++){
                        System.out.printf("%4.1f ", a[i][j]);
                    }
                }
                else{
                    for(int j = 0; j < a[0].length; j++){
                        System.out.print("     ");
                    }
                }
                System.out.print(" * ");
                if(i < b.length){
                    for(int j = 0; j < b[i].length; j++){
                        System.out.printf("%4.1f ", b[i][j]);
                    }
                }
                else{
                    for(int j = 0; j < b[0].length; j++){
                        System.out.print("     ");
                    }
                }
                System.out.print(" = ");
                if(i < c.length){
                    for(int j = 0; j < c[i].length; j++){
                        System.out.printf("%4.1f ", c[i][j]);
                    }
                }
                else{
                    for(int j = 0; j < c[0].length; j++){
                        System.out.print("     ");
                    }
                }
                System.out.println();
            }
            else{
                if(i < a.length){
                    for(int j = 0; j < a[i].length; j++){
                        System.out.printf("%4.1f ", a[i][j]);
                    }
                }
                else{
                    for(int j = 0; j < a[0].length; j++){
                        System.out.print("     ");
                    }
                }
                System.out.print("   ");
                if(i < b.length){
                    for(int j = 0; j < b[i].length; j++){
                        System.out.printf("%4.1f ", b[i][j]);
                    }
                }
                else{
                    for(int j = 0; j < b[0].length; j++){
                        System.out.print("     ");
                    }
                }
                System.out.print("   ");
                if(i < c.length){
                    for(int j = 0; j < c[i].length; j++){
                        System.out.printf("%4.1f ", c[i][j]);
                    }
                }
                else{
                    for(int j = 0; j < c[0].length; j++){
                        System.out.print("     ");
                    }
                }
                System.out.println();
            }
        }
    }
}
