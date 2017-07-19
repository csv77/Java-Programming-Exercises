package exercise_21_12;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Exercise_21_12 {

    public static void main(String[] args) {
        System.out.print("Enter a filename for baby name ranking: ");
        String filename = new Scanner(System.in).next();
        ArrayList<String> list = new ArrayList<>();
        
        HashSet<String> setBoys = new HashSet<>();
        HashSet<String> setGirls = new HashSet<>();
        try {
            URL url = new URL("http://www.cs.armstrong.edu/liang/data/" + filename);
            Scanner input = new Scanner(url.openStream());
            while(input.hasNext()) {
                for(int i = 0; i < 5; i++) {
                    list.add(i, input.next());
                }
                setBoys.add(list.get(1));
                setGirls.add(list.get(3));
                list.clear();
            }
        }
        catch (MalformedURLException ex) {
            System.out.println("Invalid URL");
        }
        catch (IOException ex){
            System.out.println("I/O error: no such file");
        }
        setBoys.retainAll(setGirls);
        
        System.out.println(setBoys.size() + " names used for both genders");
        System.out.print("They are ");
        for(String name : setBoys) {
            System.out.print(name + " ");
        }
        System.out.println();
    }
}
