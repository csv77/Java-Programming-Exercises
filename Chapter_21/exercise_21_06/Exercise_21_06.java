package exercise_21_06;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Exercise_21_06 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter numbers, 0 closes the input: ");
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int number;
        
        while((number = input.nextInt()) != 0) {
            if(!map.containsKey(number)) {
                map.put(number, 1);
            }
            else {
                map.put(number, map.get(number) + 1);
            }
        }
        
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        int max = Collections.max(map.values());
        
        System.out.println("The max value(s) of the map: ");
        for(Map.Entry<Integer, Integer> entry : entrySet) {
            if(max == entry.getValue()) {
                System.out.print(entry.getKey()+ " ");
            }
        }
        System.out.println();
    }
    
}
