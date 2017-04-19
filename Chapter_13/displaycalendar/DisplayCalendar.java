package displaycalendar;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DisplayCalendar {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Usage java DisplayCalendar month year");
            System.exit(1);
        }
        
        Calendar calendar = new GregorianCalendar(Integer.parseInt(args[1]), Integer.parseInt(args[0]) - 1, 1);
        printHeader(calendar);
        for(int i = 1; i < calendar.get(Calendar.DAY_OF_WEEK); i++) {
            System.out.print("    ");
        }
                
        while(calendar.get(Calendar.DATE) < calendar.getActualMaximum(Calendar.DATE)) {
            if(calendar.get(Calendar.DAY_OF_WEEK) == 7) {
                System.out.printf("%4d\n", calendar.get(Calendar.DAY_OF_MONTH));
            }
            else {
                System.out.printf("%4d", calendar.get(Calendar.DAY_OF_MONTH));
            }
            calendar.add(Calendar.DATE, 1);
        }
        System.out.printf("%4d", calendar.get(Calendar.DATE));
    }
    
    public static String[] getMonth() {
        String[] month = {"January", "February", "March", "April", "May", "June",
                          "July", "August", "September", "October", "November", "December"};
        return month;
    }

    public static void printHeader(Calendar calendar) {
        String[] month = getMonth();
        int length = 29 / 2 - (month[calendar.get(Calendar.MONTH)].length() / 2 + 3);
        System.out.println();
        for (int i = 0; i < length; i++) {
            System.out.print(" ");
        }
        System.out.println(month[calendar.get(Calendar.MONTH)] + ", " + calendar.get(Calendar.YEAR));
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }
}