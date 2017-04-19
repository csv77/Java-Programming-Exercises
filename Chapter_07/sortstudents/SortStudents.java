package sortstudents;
import java.util.Scanner;

public class SortStudents {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();
        String[] namesOfStudents = new String[numberOfStudents];
        int[] scoresOfStudents = new int[numberOfStudents];
        for(int i = 0; i < numberOfStudents; i++){
            System.out.print("Enter the name of the " + (i + 1) + ". student: ");
            namesOfStudents[i] = input.next();
            System.out.print("Enter the score of the " + (i + 1) + ". student: ");
            scoresOfStudents[i] = input.nextInt();
        }
        sortArrays(namesOfStudents, scoresOfStudents);
        displayArrays(namesOfStudents, scoresOfStudents);
    }
    
    public static void sortArrays(String[] names, int[] scores){
        for(int i = 0 ; i < scores.length - 1; i++){
            int currentMax = scores[i];
            int currentMaxIndex = i;
            String currentName = names[i];
            for(int j = i + 1; j < scores.length; j++){
                if(currentMax < scores[j]){
                    currentMax = scores[j];
                    currentName = names[j];
                    currentMaxIndex = j;
                }
            }
            if(currentMax != scores[i]){
                scores[currentMaxIndex] = scores[i];
                names[currentMaxIndex] = names[i];
                scores[i] = currentMax;
                names[i] = currentName;
            }
        }
    }
    
    public static void displayArrays(String[] names, int[] scores){
        System.out.println("\nThe names and scores in decreasing order:");
        for(int i = 0; i < names.length; i++){
            System.out.printf("%-10s %4d\n", names[i], scores[i]);
        }
    }
}
