package exercise_20_09;

import java.util.Comparator;

public class BallComparator implements Comparator<Ball> {

    @Override
    public int compare(Ball o1, Ball o2) {
        if(o1.getRadius() > o2.getRadius()) {
            return 1;
        }
        else if(o1.getRadius() == o2.getRadius()) {
            return 0;
        }
        else {
            return -1;
        }
    }
    
}
