package exercise_23_01;

import exercise_20_21.Circle;
import exercise_20_21.GeometricObject;
import exercise_20_21.GeometricObjectComparator;
import exercise_20_21.Rectangle;
import java.util.Comparator;

public class Exercise_23_01 {

    public static void main(String[] args) {
        String[] words = {"word", "apple", "zip", "bubble", "array"};
        bubbleSort(words);
        for(String word : words) {
            System.out.println(word);
        }
        
        System.out.println();
        
        GeometricObject[] list = {new Circle(5), new Rectangle(4, 5), new Circle(5.5),
            new Rectangle(2.4, 5), new Circle(0.5), new Rectangle(4, 65), new Circle(4.5),
            new Rectangle(4.4, 1), new Circle(6.5), new Rectangle(4, 5)};
        
        GeometricObjectComparator comparator = new GeometricObjectComparator();
        bubbleSort(list, comparator);
        
        for(GeometricObject o : list) {
            System.out.printf("%.2f\n", o.getArea());
        }
    }
    
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean needNextPass = true;
        for(int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for(int i = 0; i < list.length - k; i++) {
                if(list[i].compareTo(list[i + 1]) > 0) {
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }
    
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean needNextPass = true;
        for(int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for(int i = 0; i < list.length - k; i++) {
                if(comparator.compare(list[i], list[i + 1]) > 0) {
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }
}
