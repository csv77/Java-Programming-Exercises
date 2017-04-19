package testdate;
import java.util.Date;

public class TestDate {

    public static void main(String[] args) {
        Date date = new Date();
        for(int i  = 4; i < 12; i++){
            date.setTime((long)Math.pow(10, i));
            System.out.println("The time is: " + date.toString());
        }
    }
    
}
