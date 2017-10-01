package exercise_30_15;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Exercise_30_15 {

    public static void main(String[] args) {
        final int N = 9000000;
        double[] list = new double[N];
        for(int i = 0; i < list.length; i++) {
            list[i] = Math.random() * 10;
        }
        
        double sum = 0;
        long startTime = System.currentTimeMillis();
        sum = parallelSum(list);
        long endTime = System.currentTimeMillis();
        System.out.println("\nParallel time with " + Runtime.getRuntime().availableProcessors() + 
          " processors is " + (endTime - startTime) + " milliseconds");
        System.out.println("The sum is: " + sum);
        
        sum = 0;
        startTime = System.currentTimeMillis();
        for(int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        endTime = System.currentTimeMillis();
        System.out.println("\nSequential time is " + (endTime - startTime) + " milliseconds");
        System.out.println("The sum is: " + sum);
    }
    
    public static double parallelSum(double[] list) {
        RecursiveTask<Double> sumTask = new SumTask(0, list.length, list);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(sumTask);
    }
    
    private static class SumTask extends RecursiveTask {
        private int first;
        private int last;
        private final int THRESHOLD = 50000;
        private double[] list;
        
        public SumTask(int first, int last, double[] list) {
            this.first = first;
            this.last = last;
            this.list = list;
        }
        
        @Override
        protected Double compute() {
            if(last - first < THRESHOLD) {
                double sum = 0;
                for(int i = first; i < last; i++) {
                    sum += list[i];
                }
                return sum;
            }
            else {
                int mid = (last + first) / 2;
                RecursiveTask<Double> left = new SumTask(first, mid, list);
                RecursiveTask<Double> right = new SumTask(mid, last, list);
                left.fork();
                right.fork();
                return left.join() + right.join();
            }
        }
    }
}
