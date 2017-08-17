package exercise_23_13;

import static exercise_23_01.Exercise_23_01.bubbleSort;
import static exercise_23_02.Exercise_23_02.mergeSort;
import static exercise_23_05.Exercise_23_05.heapSort;
import static exercise_23_12.Exercise_23_12.radixSort;
import java.util.Stack;

public class Exercise_23_13 {

    public static void main(String[] args) {
        System.out.println("Array      |   Selection      Bubble       Merge       Quick        Heap       Radix");
        System.out.println("size       |   Sort           Sort         Sort        Sort         Sort       Sort ");
        System.out.println("-------------------------------------------------------------------------------------------");
        
        for(int i = 5000; i <= 30000; i += 5000) {
            Integer[] list = new Integer[i];
            for(int j = 0; j < list.length; j++) {
                list[j] = (int)(Math.random() * i);
            }
            System.out.printf("%7d    |%12d%12d%12d%12d%12d%12d\n", i, executionTimeSelectionSort(list),
                    executionTimeBubbleSort(list), executionTimeMergeSort(list), executionTimeQuickSort(list),
                    executionTimeHeapSort(list), executionTimeRadixSort(list, i));
        }
    }
    
    public static <E extends Comparable<E>> void selectionSort(E[] list) {
        for(int i = 0; i < list.length - 1; i++) {
            E min = list[i];
            int minIndex = i;
            for(int j = i + 1; j < list.length; j++) {
                if(min.compareTo(list[j]) > 0) {
                    min = list[j];
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                list[minIndex] = list[i];
                list[i] = min;
            }
        }
    }
    
    public static void quickSort(Integer[] numbers) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(numbers.length);

        while(!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            if (end - start < 2) {
                continue;
            }
            int p = start + ((end - start) / 2);
            p = partition(numbers, p, start, end);

            stack.push(p + 1);
            stack.push(end);

            stack.push(start);
            stack.push(p);
        }
    }

    private static int partition(Integer[] input, int position, int start, int end) {
        int l = start;
        int h = end - 2;
        int piv = input[position];
        swap(input, position, end - 1);

        while(l < h) {
            if (input[l] < piv) {
                l++;
            }
            else if (input[h] >= piv) {
                h--;
            }
            else {
                swap(input, l, h);
            }
        }
        int idx = h;
        if(input[h] < piv) {
            idx++;
        }
        swap(input, end - 1, idx);
        return idx;
    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <E extends Comparable<E>> long executionTimeSelectionSort(E[] list) {
        long startTime = System.currentTimeMillis();
        selectionSort(list);
        return System.currentTimeMillis() - startTime;
    }
    
    public static <E extends Comparable<E>> long executionTimeBubbleSort(E[] list) {
        long startTime = System.currentTimeMillis();
        bubbleSort(list);
        return System.currentTimeMillis() - startTime;
    }
    
    public static <E extends Comparable<E>> long executionTimeMergeSort(E[] list) {
        long startTime = System.currentTimeMillis();
        mergeSort(list);
        return System.currentTimeMillis() - startTime;
    }
    
    public static <E extends Comparable<E>> long executionTimeQuickSort(Integer[] list) {
        long startTime = System.currentTimeMillis();
        quickSort(list);
        return System.currentTimeMillis() - startTime;
    }
    
    public static <E extends Comparable<E>> long executionTimeHeapSort(E[] list) {
        long startTime = System.currentTimeMillis();
        heapSort(list);
        return System.currentTimeMillis() - startTime;
    }
    
    public static <E extends Comparable<E>> long executionTimeRadixSort(Integer[] list, int numberOfDigits) {
        long startTime = System.currentTimeMillis();
        radixSort(list, numberOfDigits);
        return System.currentTimeMillis() - startTime;
    }
}
