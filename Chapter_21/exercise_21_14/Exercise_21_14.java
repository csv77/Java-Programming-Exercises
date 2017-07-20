package exercise_21_14;

import java.net.URL;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Exercise_21_14 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a URL: ");
        String url = input.nextLine(); 
        crawler(url);
    }

    public static void crawler(String startingURL) {
        LinkedHashSet<String> listOfPendingURLs = new LinkedHashSet<>();
        HashSet<String> listOfTraversedURLs = new HashSet<>();
        HashSet<String> subURLs = new HashSet<>();
        
        listOfPendingURLs.add(startingURL);
        while (!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100) {
            for(String urlString : listOfPendingURLs) {
                System.out.println("Crawl " + urlString);
                subURLs.addAll(getSubURLs(urlString));
            }
            listOfTraversedURLs.addAll(listOfPendingURLs);
            subURLs.removeAll(listOfTraversedURLs);
            listOfPendingURLs.clear();
            listOfPendingURLs.addAll(subURLs);
        }
    }

    public static HashSet<String> getSubURLs(String urlString) {
        HashSet<String> list = new HashSet<>();

        try {
            URL url = new URL(urlString); 
            Scanner input = new Scanner(url.openStream());
            int current = 0;
            while (input.hasNext()) {
                String line = input.nextLine();
                current = line.indexOf("http:", current);
                while (current > 0) {
                    int endIndex = line.indexOf("\"", current);
                    if (endIndex > 0) {
                        list.add(line.substring(current, endIndex)); 
                        current = line.indexOf("http:", endIndex);
                    }
                    else { 
                        current = -1;
                    }
                }
            } 
        }
        catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return list;
    }
}
