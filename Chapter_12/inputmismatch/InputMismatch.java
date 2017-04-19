package inputmismatch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatch {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean correct = true;
        while(correct){
            try{
                int a = input.nextInt();
                int b = input.nextInt();
                System.out.println("The sum is: " + (a + b));
                correct = false;
                
            }
            catch(InputMismatchException ex){
                System.out.println("Wrong input");
                input.nextLine();
            }
            
        }
        
    }
    
}
