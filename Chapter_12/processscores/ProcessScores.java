package processscores;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessScores {

    public static void main(String[] args) {
        ArrayList<Double> doubles = new ArrayList<>();
        try {
            URL url = new URL("http://cs.armstrong.edu/liang/data/Scores.txt");
            Scanner input = new Scanner(url.openStream());
            while(input.hasNext()){    
                doubles.add(input.nextDouble());
            }
        }
        catch (MalformedURLException ex) {
            System.out.println(ex.getMessage());
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.printf("The sum is: %.2f\n", sum(doubles));
        System.out.printf("The average is: %.2f\n", sum(doubles)/doubles.size());
        
    }
    
    public static double sum(ArrayList<Double> list){
        double sum = 0;
        for(Double e : list){
            sum += e;
        }
        return sum;
    }
    
}
