package exercise_30_13;

import static exercise_23_02.Exercise_23_02.merge;
import static exercise_23_02.Exercise_23_02.mergeSort;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Exercise_30_13 {

    public static void main(String[] args) {
        final int SIZE = 7000000;
        Integer[] list1 = new Integer[SIZE];
        Integer[] list2 = new Integer[SIZE];

        for(int i = 0; i < list1.length; i++)
            list1[i] = list2[i] = new Integer((int)(Math.random() * 10000000));

        long startTime = System.currentTimeMillis();
        parallelMergeSort(list1);
        long endTime = System.currentTimeMillis();
        System.out.println("\nParallel time with " + Runtime.getRuntime().availableProcessors() + 
          " processors is " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        mergeSort(list2);
        endTime = System.currentTimeMillis();
        System.out.println("\nSequential time is " + (endTime - startTime) + " milliseconds");
    }

    public static <E extends Comparable<E>> void parallelMergeSort(E[] list) {
        RecursiveAction mainTask = new SortTask(list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

    private static class SortTask<E extends Comparable<E>> extends RecursiveAction {
        private final int THRESHOLD = 500;
        private E[] list;

        SortTask(E[] list) {
            this.list = list;
        }

        @Override
        protected void compute() {
            if(list.length < THRESHOLD) {
                Arrays.sort(list);
            }
            else {
                E[] firstHalf = (E[])(new Comparable[list.length / 2]);
                System.arraycopy(list, 0, firstHalf, 0, list.length / 2);

                int secondHalfLength = list.length - list.length / 2;
                E[] secondHalf = (E[])(new Comparable[secondHalfLength]);
                System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);

                invokeAll(new SortTask(firstHalf), new SortTask(secondHalf));

                merge(firstHalf, secondHalf, list);
            }
        }
    }
}
