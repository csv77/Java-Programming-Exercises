package testcomparablecircle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }
    
    @Override
    public String toString() {
        return super.toString() + "\narea: " + getArea();
    }
    
    @Override
    public int compareTo(ComparableCircle c) {
        if(getArea() > c.getArea()) {
            return 1;
        }
        else if(getArea() < c.getArea()) {
            return -1;
        }
        else {
            return 0;
        }
    }

}

