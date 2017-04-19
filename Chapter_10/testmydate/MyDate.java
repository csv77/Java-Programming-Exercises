package testmydate;

import java.util.GregorianCalendar;
import java.util.Locale;

public class MyDate {
    private int year;
    private int month;
    private int day;
    
    public MyDate(){
        GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY);
        this.year = calendar.get(GregorianCalendar.YEAR);
        this.month = calendar.get(GregorianCalendar.MONTH);
        this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }
    
    public MyDate(long elapsedTime){
        setDate(elapsedTime);
    }
    
    public MyDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    
    public int getYear(){
        return year;
    }
    
    public String getMonth(){
        return month + 1 < 10 ? "0" + (month + 1) : "" + (month + 1);
    }
    
    public String getDay(){
        return day < 10 ? "0" + day : "" + day;
    }
    
    public void setDate(long elapsedTime){
        GregorianCalendar calendar = new GregorianCalendar(Locale.GERMANY);
        calendar.setTimeInMillis(elapsedTime);
        this.year = calendar.get(GregorianCalendar.YEAR);
        this.month = calendar.get(GregorianCalendar.MONTH);
        this.day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }
}