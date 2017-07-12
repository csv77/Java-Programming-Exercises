package exercise_20_08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise_20_08 {

    public static void main(String[] args) {
        ArrayList<Integer> lotteryList = new ArrayList<>();
        lotteryList.add((int)(Math.random() * 10));
        lotteryList.add((int)(Math.random() * 10));
        lotteryList.add((int)(Math.random() * 10));
        
        System.out.print("Enter your lottery number (3 digits): ");
        int guess = new Scanner(System.in).nextInt();
        System.out.print("The lottery number is: ");
        for(int i : lotteryList) {
            System.out.print(i);
        }
        System.out.println();
        
        ArrayList<Integer> guessList = digits(guess);
        
        if(lotteryList.equals(guessList)) {
            System.out.println("Your win is $10000");
        }
        else {
            int count = 0;
            for(Integer i : lotteryList) {
                if(guessList.contains(i)) {
                    count++;
                    guessList.remove(i);
                }
            }

            switch(count) {
                case 0 : 
                    System.out.println("No match");
                    break;
                case 1 :
                    System.out.println("One match, your win is $1000");
                    break;
                case 2 :
                    System.out.println("Two matches, your win is $2000");
                    break;
                case 3 :
                    System.out.println("Three matches, your win is $3000");
            }
        }
    }
    
    public static ArrayList<Integer> digits(int number) {
        ArrayList<Integer> list = new ArrayList<>();
        while(number > 0) {
            list.add(number % 10);
            number /= 10;
        }
        return list;
    }
}
