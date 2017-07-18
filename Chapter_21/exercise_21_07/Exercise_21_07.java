package exercise_21_07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Exercise_21_07 {

    public static void main(String[] args) {
        String text = "Good morning. Have a good class. Have a good visit." + 
                " Have fun!";
        
        TreeMap<String, Integer>  map = new TreeMap<>();
        
        String[] words = text.split("[ \n\t\r.,;:!?(){}]");
        for(int i = 0; i < words.length; i++) {
            String key = words[i].toLowerCase();
            
            if(key.length() > 0) {
                if(!map.containsKey(key)) {
                    map.put(key, 1);
                }
                else {
                    map.put(key, map.get(key) + 1);
                }
            }
        }
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        ArrayList<WordOccurrence> list = new ArrayList<>();
        
        for(Map.Entry<String, Integer> entry : entrySet) {
            WordOccurrence word = new WordOccurrence(entry.getKey(), entry.getValue());
            list.add(word);
        }
        Collections.sort(list);
        
        for(WordOccurrence word : list) {
            System.out.println(word);
        }
    }
}
