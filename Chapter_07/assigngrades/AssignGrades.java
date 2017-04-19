package assigngrades;
import java.util.Scanner;

public class AssignGrades {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int length = input.nextInt();
        System.out.print("Enter " + length + " scores: ");
        String data = "";
        int[] scores = new int[length];
        char[] grades = new char[length];
        for(int i = 0; i < scores.length; i++){
            data = input.next();
            scores[i] = Integer.parseInt(data);
        }
        int max = scores[0];
        for(int i = 0; i < scores.length; i++){
            if(max < scores[i]){
                max = scores[i];
            }
        }
        for(int i = 0; i < scores.length; i++){
            if(scores[i] >= max - 10){
                grades[i] = 'A';
            }
            else if(scores[i] >= max - 20){
                grades[i] = 'B';
            }
            else if(scores[i] >= max - 30){
                grades[i] = 'C';
            }
            else if(scores[i] >= max - 40){
                grades[i] = 'D';
            }
            else
                grades[i] = 'F';
            System.out.println("Student " + i + " score is " + scores[i] + " and grade is " + grades[i]);
        }
    }
}
