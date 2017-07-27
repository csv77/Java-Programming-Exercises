package exercise_22_05;

import java.util.LinkedList;
import java.util.Scanner;

public class Exercise_22_05 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        
        System.out.println("Enter a series of numbers ending with 0:");
        int n;
        
        while((n = input.nextInt()) != 0) {
            list.add(n);
        }
        
        int index = -1;
        int maxIndex = 0;
        int sequenceLength = 0;
        int maxSequenceLength = 0;
        
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) == list.get(i + 1)) {
                if(index == -1) {
                    index = i;
                }
                
                if(sequenceLength == 0) {
                    sequenceLength = 2;
                }
                else {
                    sequenceLength++;
                }
                
                if(maxSequenceLength < sequenceLength) {
                    maxSequenceLength = sequenceLength;
                    maxIndex = index;
                }
            }
            else {
                sequenceLength = 0;
                index = -1;
            }
        }
        
        System.out.println("The longest same number sequence starts at index " +
                maxIndex + " with " + maxSequenceLength + " values of " + list.get(maxIndex));
    }
}
