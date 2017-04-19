package testrectanglecomparable;

public abstract class GeometricObject implements Comparable<GeometricObject>{
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color +
        " and filled: " + filled;
    }
    
    public abstract double getArea();
    
    public abstract double getPerimeter();
    
    @Override
    public int compareTo(GeometricObject g) {
        if(getArea() > g.getArea()) {
            return 1;
        }
        else if (getArea() < g.getArea()) {
            return -1;
        }
        else
            return 0;
    }
    
    public static GeometricObject max(GeometricObject g1, GeometricObject g2) {
        return g1.compareTo(g2) == 1 ? g1 : g2;
    }
}

