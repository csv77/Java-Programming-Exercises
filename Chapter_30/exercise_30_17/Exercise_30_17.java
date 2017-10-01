package exercise_30_17;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Exercise_30_17 {

    public static void main(String[] args) {
        final int N = 2000;
        double[][] a = new double[N][N];
        double[][] b = new double[N][N];
        double[][] result;
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                a[i][j] = Math.random();
            }
        }
        
        for(int i = 0; i < b.length; i++) {
            for(int j = 0; j < b[i].length; j++) {
                b[i][j] = Math.random();
            }
        }
        
        long startTime = System.currentTimeMillis();
        result = parallelMultiplyMatrix(a, b);
        long endTime = System.currentTimeMillis();
        System.out.println("\nParallel time with " + Runtime.getRuntime().availableProcessors() + 
          " processors is " + (endTime - startTime) + " milliseconds");
        
        startTime = System.currentTimeMillis();
        result = multiplyMatrix(a, b);
        endTime = System.currentTimeMillis();
        System.out.println("\nSequential time is " + (endTime - startTime) + " milliseconds");
    }
    
    public static double[][] parallelMultiplyMatrix(double[][] a, double[][] b) {
        double[][] result = new double[a.length][b[0].length];
        RecursiveAction task = new MultiplyMatrixTask(a, b, result, false, 0, 0);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
        return result;
    }
    
    private static class MultiplyMatrixTask extends RecursiveAction {
        private double[][] a;
        private double[][] b;
        private double[][] result;
        private boolean countOneElement;
        private int rowIndex;
        private int columnIndex;

        public MultiplyMatrixTask(double[][] a, double[][] b, double[][] result, boolean countOneElement, int rowIndex, int columnIndex) {
            this.a = a;
            this.b = b;
            this.result = result;
            this.countOneElement = countOneElement;
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }
        
        @Override
        protected void compute() {
            if(countOneElement) {
                for(int k = 0; k < a[0].length; k++){
                    result[rowIndex][columnIndex] += a[rowIndex][k] * b[k][columnIndex];
                }
            }
            else {
                RecursiveAction[][] tasks = new RecursiveAction[a.length][b[0].length];
                for(int i = 0; i < tasks.length; i++) {
                    for(int j = 0; j < tasks[i].length; j++) {
                        tasks[i][j] = new MultiplyMatrixTask(a, b, result, true, i, j);
                    }
                }
                for(int i = 0; i < tasks.length; i++) {
                    invokeAll(tasks[i]);
                }
            }
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
}
