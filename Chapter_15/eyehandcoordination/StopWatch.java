package eyehandcoordination;

public class StopWatch {
    private long startTime = 0;
    private long endTime = 0;
    
    public StopWatch() {
        startTime = System.currentTimeMillis();
    }
    
    public long getStartTime() {
        return startTime;
    }
    
    public long getEndTime() {
        return endTime;
    }
    
    public void start() {
        startTime = System.currentTimeMillis();
    }
    
    public void stop() {
        endTime = System.currentTimeMillis();
    }
    
    public void reset() {
        startTime = 0;
        endTime = 0;
    }
    
    public boolean isStopWatchRunning() {
        return getStartTime() != 0;
    }
    
    public long getElapsedTime() {
        return getEndTime() - getStartTime();
    }
    
}
