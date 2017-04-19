package testcalendar;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class TestCalendar {

    public static void main(String[] args) {
        GregorianCalendar calendar = new GregorianCalendar();
        System.out.println(calendar.get(GregorianCalendar.YEAR) + " " + calendar.get(GregorianCalendar.MONTH) + " " + 
                           calendar.get(GregorianCalendar.DAY_OF_MONTH));
        calendar.setTimeInMillis(1234567898765L);
        System.out.println(calendar.get(GregorianCalendar.YEAR) + " " + calendar.get(GregorianCalendar.MONTH) + " " + 
                           calendar.get(GregorianCalendar.DAY_OF_MONTH));
        
    }
    
}
