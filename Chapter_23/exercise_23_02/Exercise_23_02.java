package exercise_23_02;

import exercise_20_21.Circle;
import exercise_20_21.GeometricObject;
import exercise_20_21.GeometricObjectComparator;
import exercise_20_21.Rectangle;
import java.util.Arrays;
import java.util.Comparator;

public class Exercise_23_02 {

    public static void main(String[] args) {
        String[] words = {"word", "apple", "zip", "bubble", "array"};
        mergeSort(words);
        for(String word : words) {
            System.out.println(word);
        }
        
        System.out.println();
        
        GeometricObject[] list = {new Circle(5), new Rectangle(4, 5), new Circle(5.5),
            new Rectangle(2.4, 5), new Circle(0.5), new Rectangle(4, 65), new Circle(4.5),
            new Rectangle(4.4, 1), new Circle(6.5), new Rectangle(4, 5)};
        
        GeometricObjectComparator comparator = new GeometricObjectComparator();
        mergeSort(list, comparator);
        
        for(GeometricObject o : list) {
            System.out.printf("%.2f\n", o.getArea());
        }
    }
    
    public static <E extends Comparable<E>> void mergeSort(E[] list) {
        if(list.length > 1) {
            E[] firstHalf = (E[])new Comparable[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);
            
            int secondHalfLength = list.length - list.length / 2;
            E[] secondHalf = (E[])new Comparable[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);
            
            merge(firstHalf, secondHalf, list);
        }
    }
    
    public static <E extends Comparable<E>> void merge(E[] list1, E[] list2, E[] temp) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;
        
        while(current1 < list1.length && current2 < list2.length) {
            if(list1[current1].compareTo(list2[current2]) < 0) {
                temp[current3++] = list1[current1++];
            }
            else {
                temp[current3++] = list2[current2++];
            }
        }
        
        while(current1 < list1.length) {
            temp[current3++] = list1[current1++];
        }
        
        while(current2 < list2.length) {
            temp[current3++] = list2[current2++];
        }
    }
    
    public static <E> void mergeSort(E[] list, Comparator<? super E> comparator) {
        if(list.length > 1) {
            E[] firstHalf = Arrays.copyOfRange(list, 0, list.length / 2);
            mergeSort(firstHalf, comparator);
            
            E[] secondHalf = Arrays.copyOfRange(list, list.length / 2, list.length);
            mergeSort(secondHalf, comparator);
            
            merge(firstHalf, secondHalf, list, comparator);
        }
    }
    
    public static <E> void merge(E[] list1, E[] list2, E[] temp, Comparator<? super E> comparator) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;
        
        while(current1 < list1.length && current2 < list2.length) {
            if(comparator.compare(list1[current1], list2[current2]) < 0) {
                temp[current3++] = list1[current1++];
            }
            else {
                temp[current3++] = list2[current2++];
            }
        }
        
        while(current1 < list1.length) {
            temp[current3++] = list1[current1++];
        }
        
        while(current2 < list2.length) {
            temp[current3++] = list2[current2++];
        }
    }
}
