package exercise_22_07;

public class Point implements Comparable<Point> {
    private double x;
    private double y;
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public Point() {
        this(0, 0);
    }
    
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if(x > o.getX()) {
            return 1;
        }
        else if(x == o.getX()) {
            if(y > o.getY()) {
                return 1;
            }
            else if(y == o.getY()) {
                return 0;
            }
            else {
                return -1;
            }
        }
        else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "(" + String.format("%.2f", x) + ", " + String.format("%.2f", y) + ")";
    }
    
}
