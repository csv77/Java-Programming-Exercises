package exercise_19_02;

import java.util.Scanner;

public class Exercise_19_02 {

    public static void main(String[] args) {
        GenericStack<String> stringStack = new GenericStack<>();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 5 strings: ");
        
        for(int i = 0; i < 5; i++) {
            stringStack.push(input.next());
        }
        
        while(!stringStack.isEmpty()) {
            System.out.print(stringStack.pop() + " ");
        }
        System.out.println();
    }
}
