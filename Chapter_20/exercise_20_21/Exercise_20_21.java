package exercise_20_21;

import java.util.Comparator;

public class Exercise_20_21 {

    public static void main(String[] args) {
        GeometricObject[] list = {new Circle(5), new Rectangle(4, 5), new Circle(5.5),
            new Rectangle(2.4, 5), new Circle(0.5), new Rectangle(4, 65), new Circle(4.5),
            new Rectangle(4.4, 1), new Circle(6.5), new Rectangle(4, 5)};
        
        GeometricObjectComparator comparator = new GeometricObjectComparator();
        selectionSort(list, comparator);
        
        for(GeometricObject o : list) {
            System.out.printf("%.2f\n", o.getArea());
        }
    }
    
    public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
        for(int i = 0; i < list.length - 1; i++) {
            E min = list[i];
            int minIndex = i;
            for(int j = i + 1; j < list.length; j++) {
                if(comparator.compare(list[j], min) < 0) {
                    minIndex = j;
                    min = list[j];
                }
            }
            if(i != minIndex) {
                list[minIndex] = list[i];
                list[i] = min;
            }
        }
    }
}
