package exercise_30_14;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Exercise_30_14 {

    public static void main(String[] args) {
        final int SIZE = 7000000;
        int[] list1 = new int[SIZE];
        int[] list2 = new int[SIZE];

        for(int i = 0; i < list1.length; i++)
            list1[i] = list2[i] = (int)(Math.random() * 10000000);

        long startTime = System.currentTimeMillis();
        parallelQuickSort(list1);
        long endTime = System.currentTimeMillis();
        System.out.println("\nParallel time with " + Runtime.getRuntime().availableProcessors() + 
          " processors is " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        quickSort(list2);
        endTime = System.currentTimeMillis();
        System.out.println("\nSequential time is " + (endTime - startTime) + " milliseconds");
    }
    
    public static void parallelQuickSort(int[] list) {
        RecursiveAction mainTask = new SortTask(list, 0, list.length - 1);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }
    
    private static class SortTask extends RecursiveAction {
        private final int THRESHOLD = 20000;
        private int[] list;
        private int first;
        private int last;

        public SortTask(int[] list, int first, int last) {
            this.list = list;
            this.first = first;
            this.last = last;
        }

        @Override
        protected void compute() {
            if(list.length < THRESHOLD) {
                Arrays.sort(list);
            }
            else {
                if(last > first) {
                    int pivotIndex = partition(list, first, last);
                    invokeAll(new SortTask(list, first, pivotIndex - 1), new SortTask(list, pivotIndex + 1, last));
                }
            }
        }
    }
    
    private static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    private static void quickSort(int[] list, int first, int last) {
        if(last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    private static int partition(int[] list, int first, int last) {
        int pivot = list[first];
        int low = first + 1;
        int high = last;

        while(high > low) {
            while(low <= high && list[low] <= pivot)
                low++;

            while (low <= high && list[high] > pivot)
                high--;

            if(high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while(high > first && list[high] >= pivot)
            high--;

        if(pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else {
            return first;
        }
    }
}
