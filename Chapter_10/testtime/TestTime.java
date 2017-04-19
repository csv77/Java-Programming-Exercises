package testtime;

public class TestTime {

    public static void main(String[] args) {
        Time time1 = new Time();
        Time time2 = new Time(555550000);
        System.out.printf("%02d:%02d:%02d\n", time1.getHour(), time1.getMinute(), time1.getSecond());
        System.out.printf("%02d:%02d:%02d\n", time2.getHour(), time2.getMinute(), time2.getSecond());
    }
    
}
