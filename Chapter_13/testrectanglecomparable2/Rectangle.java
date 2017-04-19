package testrectanglecomparable2;

import testcomparablecircle.GeometricObject;

public class Rectangle extends GeometricObject implements Comparable<Rectangle>{
    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled) {
        this.width = width;
        this.height = height;
        setColor(color);
        setFilled(filled);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nwidth: " + width + "\nheight: " + height +
                "\narea: " + getArea() + "\nperimeter: " + getPerimeter();
    }
    
    @Override
    public int compareTo(Rectangle r) {
        if(getArea() > r.getArea()) {
            return 1;
        }
        else if(getArea() < r.getArea()) {
            return -1;
        }
        else {
            return 0;
        }
    }
    
    @Override
    public boolean equals(Object o) {
        return this.compareTo((Rectangle)o) == 0;
    }
}
