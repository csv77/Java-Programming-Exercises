package testrectanglecomparable;

public class Circle extends GeometricObject{
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
}
