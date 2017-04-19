package createdataset;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CreateDataset {

    public static void main(String[] args) {
        File file = new File("Salary.txt");
        if(file.exists()) {
            System.out.println("The file " + file.getName() + " is already exists!");
            System.exit(1);
        }
        ArrayList<String> list = createLines();
        try {
            try(PrintWriter output = new PrintWriter(file);) {
                for(int i = 0; i < list.size(); i++) {
                    output.println(list.get(i));
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("The file is not existing!");
        }
            
    }
    
    public static ArrayList<String> createLines() {
        ArrayList<String> lines = new ArrayList<>();
        String[] ranks = {"assistant", "associate", "full"};
        for(int i = 1; i <= 1000; i++) {
            String rank = ranks[(int)(Math.random() * ranks.length)];
            double salary = 0;
            switch(rank) {
                case "assistant" :
                    salary = 50000 + Math.random() * 30001;
                    break;
                case "associate" :
                    salary = 60000 + Math.random() * 50001;
                    break;
                case "full" :
                    salary = 75000 + Math.random() * 55001;
                    break;
            }
            lines.add("FirstName" + i + " LastName" + i + " " + rank + " " + String.format("%.2f", salary));
        }
        
        return lines;
    }
    
}
