package babynameranking;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class BabynameRanking {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the year: ");
        String year = input.next();
        System.out.print("Enter the gender: ");
        String gender = input.next();
        System.out.print("Enter the name: ");
        String name = input.next();
        
        ArrayList<String> list = new ArrayList<>();
        
        try {
            URL url = new URL("http://www.cs.armstrong.edu/liang/data/babynamesranking" + year + ".txt");
            input = new Scanner(url.openStream());
            while(input.hasNext()) {
                for(int i = 0; i < 5; i++) {
                    list.add(i, input.next());
                }
                if(name.equals(list.get(gender(gender)))) {
                    System.out.println(name + " is ranked #" + list.get(0) + " in year " + year + ". This name was add " + list.get(gender(gender) + 1) + " times.");
                    System.exit(1);
                }
                list.clear();
            }
        }
        catch (MalformedURLException ex) {
            System.out.println("Invalid URL");
        }
        catch (IOException ex){
            System.out.println("I/O error: no such file");
        }
        System.out.println("The name " + name + " is not ranked in year " + year);
    }
    
    public static int gender(String gender) {
        if(gender.equals("M")) {
            return 1;
        }
        else {
            return 3;
        }
    }
    
    
}
