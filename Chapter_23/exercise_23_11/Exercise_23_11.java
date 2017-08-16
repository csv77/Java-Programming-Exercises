package exercise_23_11;

public class Exercise_23_11 {

    public static void main(String[] args) {
        String[] words1 = {"word", "apple", "zip", "bubble", "array"};
        String[] words2 = {"character", "apple", "zip", "bubble", "array"};
        
        Heap<String> heap1 = new Heap<>(words1);
        Heap<String> heap2 = new Heap<>(words2);
        Heap<String> heap3 = (Heap)heap1.clone();
        
        System.out.println("Are heap1 and heap2 equals? " + ((heap1.equals(heap2) ? "yes" : "no")));
        System.out.println("Are heap1 and heap3 equals? " + ((heap1.equals(heap3) ? "yes" : "no")));
    }
}
