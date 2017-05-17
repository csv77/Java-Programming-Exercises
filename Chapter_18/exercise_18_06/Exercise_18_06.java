package exercise_18_06;

public class Exercise_18_06 {

    public static void main(String[] args) {
        for(int i = 1; i <=10; i++) {
            System.out.println("m(" + i + ") = " + m(i));
        }
    }
    
    public static double m(int i) {
        if(i == 1) {
            return 1.0 / 2;
        }
        else {
            return (double)i / (i + 1) + m(i - 1);
        }
    }
    
}
