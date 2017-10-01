package exercise_30_16;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Exercise_30_16 {

    public static void main(String[] args) {
        final int N = 2000;
        double[][] a = new double[N][N];
        double[][] b = new double[N][N];
        double[][] result;
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                a[i][j] = Math.random();
                b[i][j] = Math.random();
            }
        }
        
        long startTime = System.currentTimeMillis();
        result = parallelAddMatrix(a, b);
        long endTime = System.currentTimeMillis();
        System.out.println("\nParallel time with " + Runtime.getRuntime().availableProcessors() + 
          " processors is " + (endTime - startTime) + " milliseconds");
        
        startTime = System.currentTimeMillis();
        result = addMatrix(a, b);
        endTime = System.currentTimeMillis();
        System.out.println("\nSequential time is " + (endTime - startTime) + " milliseconds");
    }
    
    public static double[][] parallelAddMatrix(double[][] a, double[][] b) {
        double[][] result = new double[a.length][a[0].length];
        RecursiveAction task = new AddMatrixTask(a, b, result, false, 0);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
        return result;
    }
    
    private static class AddMatrixTask extends RecursiveAction {
        private double[][] a;
        private double[][] b;
        private double[][] result;
        private boolean addOneRow;
        private int index;

        public AddMatrixTask(double[][] a, double[][] b, double[][] result, boolean addOneRow, int index) {
            this.a = a;
            this.b = b;
            this.result = result;
            this.addOneRow = addOneRow;
            this.index = index;
        }
        
        @Override
        protected void compute() {
            if(addOneRow) {
                for(int i = 0; i < a[index].length; i++) {
                    result[index][i] = a[index][i] + b[index][i];
                }
            }
            else {
                RecursiveAction[] tasks = new RecursiveAction[a.length];
                for(int i = 0; i < tasks.length; i++) {
                    tasks[i] = new AddMatrixTask(a, b, result, true, i);
                }
                invokeAll(tasks);
            }
        }
    }
    
    public static double[][] addMatrix(double[][] a, double[][] b) {
        double[][] result = new double[a.length][a[0].length];
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }
}
