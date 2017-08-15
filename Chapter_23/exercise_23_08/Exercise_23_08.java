package exercise_23_08;

public class Exercise_23_08 {

    public static void main(String[] args) {
        Double[] numbers = {2.0, 0.1, -2.5, 10.5, 100.9, 5.2};
        sort(numbers);
        
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
    
    public static <E extends Comparable<E>> void sort(E[] list) {
        Heap<E> heap = new Heap<>(list);
        for(int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }
}
