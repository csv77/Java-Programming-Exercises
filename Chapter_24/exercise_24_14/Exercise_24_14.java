package exercise_24_14;

public class Exercise_24_14 {

    public static void main(String[] args) {
        PrimeIterator iterator = new PrimeIterator(100000);
        int i = 0;
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
            i++;
            if(i != 0 && i % 10 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
