package exercise_23_07;

public class Exercise_23_07 {

    public static void main(String[] args) {
        String[] words = {"word", "apple", "zip", "bubble", "array"};
        heapSort(words);
        for(String word : words) {
            System.out.println(word);
        }
    }
    
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        Heap<E> heap = new Heap<>(list);
        for(int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }
}
