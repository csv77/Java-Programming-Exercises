package exercise_21_08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Exercise_21_08 {

    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Usage: java Exercise_21_08 filename");
            System.exit(1);
        }
        
        File file = new File(args[0]);
        if(!file.exists() || !file.isFile()) {
            System.out.println("The file " + file.getName() + " doesn't exists, or it's a directory");
            System.exit(2);
        }
        
        TreeMap<String, Integer>  map = new TreeMap<>();
        String line = "";
        
        try(BufferedReader input = new BufferedReader(new FileReader(file));) {
            while((line = input.readLine()) != null) {
                for(String word : line.toLowerCase().split("[ \n\t\r.,;:!?\'\"(){}]")) {
                    if(word.length() > 0 && Character.isLetter(word.charAt(0))) {
                        if(!map.containsKey(word)) {
                            map.put(word, 1);
                        }
                        else {
                            map.put(word, map.get(word) + 1);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("IOException");
        }
        
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for(Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getValue() + "\t" + entry.getKey());
        }
    }
}
