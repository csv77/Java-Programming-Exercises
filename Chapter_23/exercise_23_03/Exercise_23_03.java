package exercise_23_03;

import exercise_20_21.Circle;
import exercise_20_21.GeometricObject;
import exercise_20_21.GeometricObjectComparator;
import exercise_20_21.Rectangle;
import java.util.Comparator;

public class Exercise_23_03 {

    public static void main(String[] args) {
        String[] words = {"word", "apple", "zip", "bubble", "array"};
        quickSort(words);
        for(String word : words) {
            System.out.println(word);
        }
        
        System.out.println();
        
        GeometricObject[] list = {new Circle(5), new Rectangle(4, 5), new Circle(5.5),
            new Rectangle(2.4, 5), new Circle(0.5), new Rectangle(4, 65), new Circle(4.5),
            new Rectangle(4.4, 1), new Circle(6.5), new Rectangle(4, 5)};
        
        GeometricObjectComparator comparator = new GeometricObjectComparator();
        quickSort(list, comparator);
        
        for(GeometricObject o : list) {
            System.out.printf("%.2f\n", o.getArea());
        }
    }
    
    public static <E extends Comparable<E>> void quickSort(E[] list) {
        quickSort(list, 0, list.length - 1);
    }
    
    public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
        if(last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }
    
    public static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
        E pivot = list[first];
        int low = first + 1;
        int high = last;
        
        while(high > low) {
            while(low <= high && list[low].compareTo(pivot) <= 0) {
                low++;
            }
            
            while(low <= high && list[high].compareTo(pivot) > 0) {
                high--;
            }
            
            if(high > low) {
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        
        while(high > first && list[high].compareTo(pivot) >= 0) {
            high--;
        }
        
        if(pivot.compareTo(list[high]) > 0) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else {
            return first;
        }
    }
    
    public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
        quickSort(list, 0, list.length - 1, comparator);
    }
    
    public static <E> void quickSort(E[] list, int first, int last, Comparator<? super E> comparator) {
        if(last > first) {
            int pivotIndex = partition(list, first, last, comparator);
            quickSort(list, first, pivotIndex - 1, comparator);
            quickSort(list, pivotIndex + 1, last, comparator);
        }
    }
    
    public static <E> int partition(E[] list, int first, int last, Comparator<? super E> comparator) {
        E pivot = list[first];
        int low = first + 1;
        int high = last;
        
        while(high > low) {
            while(low <= high && comparator.compare(list[low], pivot) <= 0) {
                low++;
            }
            
            while(low <= high && comparator.compare(list[high], pivot) > 0) {
                high--;
            }
            
            if(high > low) {
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        
        while(high > first && comparator.compare(list[high], pivot) >= 0) {
            high--;
        }
        
        if(comparator.compare(pivot, list[high]) > 0) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else {
            return first;
        }
    }
}
