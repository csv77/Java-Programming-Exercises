package exercise_18_04;

public class Exercise_18_04 {

    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++) {
            System.out.println("The sum is " + m(i));
        }
    }
    
    public static double m(int i) {
        if(i == 1) {
            return 1;
        }
        else {
            return 1.0 / i + m(i - 1);
        }
        
    }
}
