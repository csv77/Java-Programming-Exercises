package testcirclecomparable;

import testcomparablecircle.GeometricObject;

public class Circle extends GeometricObject implements Comparable<Circle>{
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getDiameter() {
        return 2 * radius;
    }
    
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return this.getDiameter() * Math.PI;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nradius: " + radius +
                "\narea: " + getArea() + "\nperimeter: " + getPerimeter();
    }

    @Override
    public int compareTo(Circle c) {
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
    
    @Override
    public boolean equals(Object o) {
        return this.compareTo((Circle)o) == 0;
    }
}

