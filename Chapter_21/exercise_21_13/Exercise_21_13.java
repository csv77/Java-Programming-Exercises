package exercise_21_13;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Exercise_21_13 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean anotherQuery = true;
        HashMap[][] rankings = getData();
        int ranking;
        
        while(anotherQuery) {
            System.out.print("Enter the year: ");
            int year = input.nextInt();
            
            System.out.print("Enter the gender: ");
            int gender = (input.next().toUpperCase().equals("M")) ? 0 : 1;
            
            System.out.print("Enter the name: ");
            String name = input.next();
            
            try {
                if(rankings[gender][year - 2001].containsKey(name)) {
                    ranking = (Integer)rankings[gender][year - 2001].get(name);
                    if(gender == 0) {
                        System.out.println("Boy name " + name + " is ranked #" + ranking + " in year " + year);
                    }
                    else if(gender == 1) {
                        System.out.println("Girl name " + name + " is ranked #" + ranking + " in year " + year);
                    }
                }
                else if(gender == 0) {
                    System.out.println("The list of boys doesn't contain this name");
                }
                else if(gender == 1) {
                    System.out.println("The list of girls doesn't contain this name");
                }

                System.out.print("Enter another inquiry? ");
                anotherQuery = input.next().toUpperCase().equals("Y");
            }
            catch(ArrayIndexOutOfBoundsException ex) {
                System.out.println("Invalid year");
            }
        }
    }
    
    public static HashMap[][] getData() {
        HashMap[][] mapArray = new HashMap[2][10];
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            HashMap<String, Integer> mapBoys = new HashMap<>();
            HashMap<String, Integer> mapGirls = new HashMap<>();
            try {
                URL url = new URL("http://www.cs.armstrong.edu/liang/data/babynamesranking" + (i + 2001) + ".txt");
                Scanner input = new Scanner(url.openStream());
                while(input.hasNext()) {
                    for(int j = 0; j < 5; j++) {
                        list.add(j, input.next());
                    }
                    mapBoys.put(list.get(1), Integer.parseInt(list.get(0)));
                    mapGirls.put(list.get(3), Integer.parseInt(list.get(0)));
                    list.clear();
                }
            }
            catch (MalformedURLException ex) {
                System.out.println("Invalid URL");
            }
            catch (IOException ex){
                System.out.println("I/O error: no such file");
            }
            mapArray[0][i] = mapBoys;
            mapArray[1][i] = mapGirls;
        }
        return mapArray;
    }
}
