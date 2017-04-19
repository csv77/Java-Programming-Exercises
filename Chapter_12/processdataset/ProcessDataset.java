package processdataset;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessDataset {

    public static void main(String[] args) {
        ArrayList<Double> assistant = new ArrayList<>();
        ArrayList<Double> associate = new ArrayList<>();
        ArrayList<Double> full = new ArrayList<>();
        
        try {
            URL url = new URL("http://cs.armstrong.edu/liang/data/Salary.txt");
            Scanner input = new Scanner(url.openStream());
            while(input.hasNext()) {
                String[] line = input.nextLine().split(" ");
                if(line[2].equals("assistant")) {
                    assistant.add(Double.parseDouble(line[3]));
                }
                else if(line[2].equals("associate")) {
                    associate.add(Double.parseDouble(line[3]));
                }
                else {
                    full.add(Double.parseDouble(line[3]));
                }
            }
        }
        catch (MalformedURLException ex) {
            System.out.println("Invalid URL");
        }
        catch (IOException ex) {
            System.out.println("I/O Error: no such file");
        }
        System.out.printf("Assistant's total payment: %.2f, and average: %.2f\n", sum(assistant), sum(assistant)/assistant.size());
        System.out.printf("Associate's total payment: %.2f, and average: %.2f\n", sum(associate), sum(associate)/associate.size());
        System.out.printf("Full's total payment: %.2f, and average: %.2f\n", sum(full), sum(full)/full.size());
    }
    
    public static double sum(ArrayList<Double> list) {
        double sum = 0;
        for(Double a : list){
            sum += a;
        }
        return sum;
    }
}
