package countwords;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class CountWords {

    public static void main(String[] args) {
        int count = 0;
        try{
            URL url = new URL("http://cs.armstrong.edu/liang/data/Lincoln.txt");
            Scanner input = new Scanner(url.openStream());
            while(input.hasNext()){
                String s = input.next();
                count++;
            }
            input.close();
            System.out.println("Number of words: " + count);
        }
        catch(MalformedURLException ex){
            System.out.println("Invalid URL");
        }
        catch(IOException ex){
            System.out.println("I/O Errors: no such file");
        }
        
        
    }
}
