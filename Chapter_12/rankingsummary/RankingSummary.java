package rankingsummary;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class RankingSummary {

    public static void main(String[] args) {
        printHeader();
        ArrayList<String> girls = new ArrayList<>();
        ArrayList<String> boys = new ArrayList<>();
        ArrayList<String> line = new ArrayList<>();
        
        for(int year = 2010; year >= 2001; year--) {
            try {
                URL url = new URL("http://www.cs.armstrong.edu/liang/data/babynamesranking" + year + ".txt");
                Scanner input = new Scanner(url.openStream());
                for(int i = 0; i < 5 && input.hasNext(); i++) {
                    for(int j = 0; j < 5; j++) {
                        line.add(j, input.next());
                    }
                    girls.add(line.get(3));
                    boys.add(line.get(1));
                }
            }
            catch (MalformedURLException ex) {
                System.out.println("Invalid URL");
            }
            catch (IOException ex){
                System.out.println("I/O error: no such file");
            }
            print(year, girls, boys);
            girls.clear();
            boys.clear();
        }
    }
    
    public static void print(int year, ArrayList<String> girls, ArrayList<String> boys) {
        System.out.print(year + "       ");
        for(int i = 0; i < girls.size(); i++) {
            System.out.print(girls.get(i) + print(girls.get(i)));
        }
        for(int i = 0; i < boys.size(); i++) {
            System.out.print(boys.get(i) + print(boys.get(i)));
        }
        System.out.println();
    }
    
    public static String print(String name) {
        String space = "";
        for(int i = 0; i < 12 - name.length(); i++) {
            space += " ";
        }
        return space;
    }
    
    public static void printHeader() {
        System.out.println("--------------------------------------------------------------"
                + "-----------------------------------------------------------------------");
        System.out.println("Year       Rank1       Rank2       Rank3       Rank4       Rank5"
                + "       Rank1       Rank2       Rank3       Rank4       Rank5");
        System.out.println("--------------------------------------------------------------"
                + "-----------------------------------------------------------------------");
        
    }
}
