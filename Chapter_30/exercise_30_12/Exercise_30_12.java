package exercise_30_12;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Exercise_30_12 {
    private static final int N = 9000000;
    
    public static void main(String[] args) {
        double[] list = new double[N];
        
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < list.length; i++) {
            list[i] = Math.random() * N;
        }
        System.out.println("Sequential algorithm execution time: " + (System.currentTimeMillis() - startTime) + " ms");
        
        startTime = System.currentTimeMillis();
        parallelAssignValues(list);
        System.out.println("Parallel algorithm execution time: " + (System.currentTimeMillis() - startTime) + " ms");
    }
    
    public static void parallelAssignValues(double[] list) {
        RecursiveAction task = new AssignValuesTask(0, list.length, list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
    }
    
    private static class AssignValuesTask extends RecursiveAction {
        private int low;
        private int high;
        private final int THRESHOLD = 5000;
        private double[] list;

        public AssignValuesTask(int low, int high, double[] list) {
            this.low = low;
            this.high = high;
            this.list = list;
        }
        
        @Override
        protected void compute() {
            Random random = new Random();
            if(high - low < THRESHOLD) {
                for(int i = low; i < high; i++) {
                    list[i] = random.nextDouble();
                }
            }
            else {
                int mid = (high + low) / 2;
                invokeAll(new AssignValuesTask(low, mid, list), new AssignValuesTask(mid, high, list));
            }
        }
    }
}
