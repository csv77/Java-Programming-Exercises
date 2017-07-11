package exercise_20_03;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Exercise_20_03 {
    private static String[][] stateCapitals = {
            {"Alabama", "Montgomery"},
            {"Alaska", "Juneau"},
            {"Arizona", "Phoenix"},
            {"Arkansas", "Little Rock"},
            {"California", "Sacramento"},
            {"Colorado", "Denver"},
            {"Connecticut", "Hartford"},
            {"Delaware", "Dover"},
            {"Florida", "Tallahassee"},
            {"Georgia", "Atlanta"},
            {"Hawaii", "Honolulu"},
            {"Idaho", "Boise"},
            {"Illinois", "Springfield"},
            {"Maryland", "Annapolis"},
            {"Minnesota", "Saint Paul"},
            {"Iowa", "Des Moines"},
            {"Maine", "Augusta"},
            {"Kentucky", "Frankfort"},
            {"Indiana", "Indianapolis"},
            {"Kansas", "Topeka"},
            {"Louisiana", "Baton Rouge"},
            {"Oregon", "Salem"},
            {"Oklahoma", "Oklahoma City"},
            {"Ohio", "Columbus"},
            {"North Dakota", "Bismark"},
            {"New York", "Albany"},
            {"New Mexico", "Santa Fe"},
            {"New Jersey", "Trenton"},
            {"New Hampshire", "Concord"},
            {"Nevada", "Carson City"},
            {"Nebraska", "Lincoln"},
            {"Montana", "Helena"},
            {"North Carolina", "Raleigh"},
            {"Missouri", "Jefferson City"},
            {"Mississippi", "Jackson"},
            {"Massachusetts", "Boston"},
            {"Michigan", "Lansing"},
            {"Pennsylvania", "Harrisburg"},
            {"Rhode Island", "Providence"},
            {"South Carolina", "Columbia"},
            {"South Dakota", "Pierre"},
            {"Tennessee", "Nashville"},
            {"Texas", "Austin"},
            {"Utah", "Salt Lake City"},
            {"Vermont", "Montpelier"},
            {"Virginia", "Richmond"},
            {"Washington", "Olympia"},
            {"West Virginia", "Charleston"},
            {"Wisconsin", "Madison"},
            {"Wyoming", "Cheyenne"}
    };
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int correctAnswers = 0;
        
        LinkedList<String[]> list = new LinkedList<>();
        Collections.addAll(list, stateCapitals);
        Collections.shuffle(list);
        
        for(String[] arrays : list) {
            System.out.print("What is the capital of " + arrays[0] + "?");
            String capital = input.nextLine();
            
            if(capital.equalsIgnoreCase(arrays[1])) {
                System.out.println("Your answer is correct");
                correctAnswers++;
            }
            else {
                System.out.println("The correct answer should be " + arrays[1]);
            }
        }
        
        System.out.println("The correct count is " + correctAnswers);
    }
    
}
