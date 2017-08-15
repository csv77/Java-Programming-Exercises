package exercise_23_06;

import exercise_20_21.Circle;
import exercise_20_21.GeometricObject;
import exercise_20_21.GeometricObjectComparator;
import exercise_20_21.Rectangle;
import java.util.Comparator;

public class Exercise_23_06 {

    public static void main(String[] args) {
        int[] integers1 = {1, 5, 3, 2, 10, 2};
        int[] integers2 = {1, 2, 2, 3, 5, 10};
        int[] integers3 = {10, 5, 3, 2, 2, 1};
        
        double[] doubles1 = {1.0, 5.0, 3.0, 2.0, 10.0, 2.0};
        double[] doubles2 = {1.0, 2.0, 2.0, 3.0, 5.0, 10.0};
        double[] doubles3 = {10.0, 5.0, 3.0, 2.0, 2.0, 1.0};
        
        String[] words1 = {"word", "apple", "zip", "bubble", "array"};
        String[] words2 = {"apple", "array", "bubble", "word", "zip"};
        String[] words3 = {"zip", "word", "bubble", "array", "apple"};
        
        GeometricObject[] list1 = {new Circle(5), new Rectangle(4, 5), new Circle(5.5),
            new Rectangle(2.4, 5), new Circle(0.5), new Rectangle(4, 65), new Circle(4.5),
            new Rectangle(4.4, 1), new Circle(6.5), new Rectangle(4, 5)};
        GeometricObject[] list2 = {new Circle(2), new Rectangle(4, 5), new Circle(10.0)};
        GeometricObject[] list3 = {new Circle(10.0), new Rectangle(4, 5), new Circle(2)};
        
        GeometricObjectComparator comparator = new GeometricObjectComparator();
        
        System.out.println("Are integers1 in ascending order? " + ordered(integers1));
        System.out.println("Are integers2 in ascending order? " + ordered(integers2, true));
        System.out.println("Are integers3 in descending order? " + ordered(integers3, false));
        
        System.out.println("Are doubles1 in ascending order? " + ordered(doubles1));
        System.out.println("Are doubles2 in ascending order? " + ordered(doubles2, true));
        System.out.println("Are doubles3 in descending order? " + ordered(doubles3, false));
        
        System.out.println("Are words1 in ascending order? " + ordered(words1));
        System.out.println("Are words2 in ascending order? " + ordered(words2, true));
        System.out.println("Are words3 in descending order? " + ordered(words3, false));
        
        System.out.println("Are list1 in ascending order? " + ordered(list1, comparator));
        System.out.println("Are list2 in ascending order? " + ordered(list2, comparator, true));
        System.out.println("Are list3 in descending order? " + ordered(list3, comparator, false));
    }
    
    public static boolean ordered(int[] list) {
        return ordered(list, true);
    }
    
    public static boolean ordered(int[] list, boolean ascending) {
        for(int i = 0; i < list.length - 1; i++) {
            if(ascending && list[i] > list[i + 1]) {
                return false;
            }
            if(!ascending && list[i] < list[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean ordered(double[] list) {
        return ordered(list, true);
    }
    
    public static boolean ordered(double[] list, boolean ascending) {
        for(int i = 0; i < list.length - 1; i++) {
            if(ascending && list[i] > list[i + 1]) {
                return false;
            }
            if(!ascending && list[i] < list[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    public static <E extends Comparable<E>> boolean ordered(E[] list) {
        return ordered(list, true);
    }
    
    public static <E extends Comparable<E>> boolean ordered(E[] list, boolean ascending) {
        for(int i = 0; i < list.length - 1; i++) {
            if(ascending && list[i].compareTo(list[i + 1]) > 0) {
                return false;
            }
            if(!ascending && list[i].compareTo(list[i + 1]) < 0) {
                return false;
            }
        }
        return true;
    }
    
    public static <E> boolean ordered(E[] list, Comparator<? super E> comparator) {
        return ordered(list, comparator, true);
    }
    
    public static <E> boolean ordered(E[] list, Comparator<? super E> comparator, boolean ascending) {
        for(int i = 0; i < list.length - 1; i++) {
            if(ascending && comparator.compare(list[i], list[i + 1]) > 0) {
                return false;
            }
            if(!ascending && comparator.compare(list[i], list[i + 1]) < 0) {
                return false;
            }
        }
        return true;
    }
}
