package testoctagon;

import testcomparablecircle.GeometricObject;

public class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon>{
    private double side;
    
    public Octagon() {
    }
    
    public Octagon(double side) {
        this.side = side;
    }
    
    public Octagon(double side, String color, boolean filled) {
        this.side = side;
        setColor(color);
        setFilled(filled);
    }
    
    public double getSide() {
        return side;
    }
    
    public void setSide(double side) {
        this.side = side;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nside: " + getSide() + "\narea: " + getArea() +
                "\nperimeter: " + getPerimeter();
    }
    
    @Override
    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * Math.pow(2, side);
    }

    @Override
    public double getPerimeter() {
        return 8 * side;
    }

    @Override
    public int compareTo(Octagon o) {
        if(getArea() > o.getArea()) {
            return 1;
        }
        else if(getArea() < o.getArea()) {
            return -1;
        }
        else {
            return 0;
        }
    }
    
    @Override
    public Octagon clone() throws CloneNotSupportedException {
        Octagon o = (Octagon)super.clone();
        return o;
    }
}
