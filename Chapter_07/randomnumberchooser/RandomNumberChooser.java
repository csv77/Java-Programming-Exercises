package randomnumberchooser;
import java.util.Arrays;

public class RandomNumberChooser {

    public static void main(String[] args) {
        System.out.println(getRandom(1,2,3,4,5));
        
    }
    
    public static int getRandom(int... numbers){
        int randomNumber = 0;
        boolean isDistinct = false;
        while(!isDistinct){
            randomNumber = (int)(Math.random() * 54 + 1);
            isDistinct = true;
            for(int i = 0; i < numbers.length; i++){
                if(randomNumber == numbers[i]){
                    isDistinct = false;
                }
            }
        }
        return randomNumber;
    }
    
}
