package testarraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TestArrayList {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a sequence of numbers ending wih 0: ");
        ArrayList<Integer> list = new ArrayList<>();
        Integer number = input.nextInt();
        while(number.intValue() != 0){
            list.add(number);
            number = input.nextInt();
        }
        System.out.println("The largest is: " + max(list));
    }
    
    public static Integer max(ArrayList<Integer> list){
        if(list == null || list.size() == 0){
            return null;
        }
        else{
            return Collections.max(list);
        }
    }
    
}
