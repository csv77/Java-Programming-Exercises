package additionquiz;

import java.util.ArrayList;
import java.util.Scanner;

public class AdditionQuiz {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int number1 = (int)(Math.random() * 10);
        int number2 = (int)(Math.random() * 10);
        Scanner input = new Scanner(System.in);
        System.out.print("What is " + number1 + " + " + number2 + "? ");
        int answer = input.nextInt();
        while(number1 + number2 != answer){
            if(list.contains(answer)){
                System.out.println("You already entered " + answer);
            }
            list.add(answer);
            System.out.print("Wrong answer. Try again. What is " + number1 + " + " + number2 + "? ");
            answer = input.nextInt();
        }
        System.out.println("You got it!");
        
        
    }
    
}
