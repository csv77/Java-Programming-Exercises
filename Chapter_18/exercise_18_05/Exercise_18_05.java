package exercise_18_05;

public class Exercise_18_05 {

    public static void main(String[] args) {
        for(int i = 1; i <=10; i++) {
            System.out.println("m(" + i + ") = " + m(i));
        }
    }
    
    public static double m(int i) {
        if(i == 1) {
            return 1 / 3.0;
        }
        else {
            return (double)i / (2 * i + 1) + m(i - 1);
        }
    }
    
}
