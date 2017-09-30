package exercise_30_04;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise_30_04 {
    private int sum = new Integer(0);
    
    public Exercise_30_04(boolean isSynchronized) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i = 0; i < 1000; i++) {
            if(isSynchronized) {
                executor.execute(new SynchronizedSumTask());
            }
            else {
                executor.execute(new SumTask());
            }
        }
        
        executor.shutdown();
        
        while(!executor.isTerminated()) {
        }
    }
    
    private class SumTask implements Runnable {

        @Override
        public void run() {
            increaseSum();
        }
    }
    
    private class SynchronizedSumTask implements Runnable {

        @Override
        public void run() {
            increaseSumWithSync();
        }
    }
    
    public void increaseSum() {
        sum++;
    }
    
    public synchronized void increaseSumWithSync() {
        sum++;
    }
    
    public static void main(String[] args) {
        Exercise_30_04 sumTestWithoutSync = new Exercise_30_04(false);
        Exercise_30_04 sumTestWithSync = new Exercise_30_04(true);
        
        System.out.println("The sum without synchronization is: " + sumTestWithoutSync.sum);
        System.out.println("The sum with synchronization is: " + sumTestWithSync.sum);
    }
}
