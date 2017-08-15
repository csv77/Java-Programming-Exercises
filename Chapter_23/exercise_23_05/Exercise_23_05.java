package exercise_23_05;

import exercise_20_21.Circle;
import exercise_20_21.GeometricObject;
import exercise_20_21.GeometricObjectComparator;
import exercise_20_21.Rectangle;
import java.util.Comparator;

public class Exercise_23_05 {

    public static void main(String[] args) {
        String[] words = {"word", "apple", "zip", "bubble", "array"};
        heapSort(words);
        for(String word : words) {
            System.out.println(word);
        }
        
        System.out.println();
        
        GeometricObject[] list = {new Circle(5), new Rectangle(4, 5), new Circle(5.5),
            new Rectangle(2.4, 5), new Circle(0.5), new Rectangle(4, 65), new Circle(4.5),
            new Rectangle(4.4, 1), new Circle(6.5), new Rectangle(4, 5)};
        
        GeometricObjectComparator comparator = new GeometricObjectComparator();
        heapSort(list, comparator);
        
        for(GeometricObject o : list) {
            System.out.printf("%.2f\n", o.getArea());
        }
    }
    
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        Heap1<E> heap = new Heap1<>(list);
        for(int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }
    
    public static <E> void heapSort(E[] list, Comparator<? super E> comparator) {
        Heap2<E> heap = new Heap2<>(list, comparator);
        for(int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }
    
}
