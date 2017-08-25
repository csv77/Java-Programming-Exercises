package exercise_24_13;

public class Exercise_24_13 {

    public static void main(String[] args) {
        FibonacciIterator iterator = new FibonacciIterator(100000);
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}
