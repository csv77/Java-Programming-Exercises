package testtime;

public class Time {
    private int hour;
    private int minute;
    private int second;
    
    Time(){
        this(0);
    }
    Time(long elapseTime){
        setTime(elapseTime);
    }
    Time(int hour, int minute, int secont){
        this.hour = hour;
        this.minute = minute;
        this.second = secont;
    }
    
    public int getHour(){
        return hour;
    }
    public int getMinute(){
        return minute;
    }
    public int getSecond(){
        return second;
    }
    public void setTime(long elapseTime){
        long ms = System.currentTimeMillis();
        long totalSeconds;
        int totalMinutes;
        int totalHours;
        if(elapseTime > 0){
            totalSeconds = elapseTime / 1000;
            second = (int)(totalSeconds % 60);
            totalMinutes = (int)(totalSeconds / 60);
            minute = totalMinutes % 60;
            totalHours = totalMinutes / 60;
            hour = totalHours % 24;
        }
        else if(elapseTime == 0){
            totalSeconds = ms / 1000;
            second = (int)(totalSeconds % 60);
            totalMinutes = (int)(totalSeconds / 60);
            minute = totalMinutes % 60;
            totalHours = totalMinutes / 60;
            hour = totalHours % 24 + 1;
        }
    }
}
