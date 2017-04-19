package testcircle2d;

public class Circle2D {
    private double x;
    private double y;
    private double radius;
    
    public Circle2D(){
        this(0, 0, 1);
    }
    
    public double getRadius(){
        return radius;
    }
    
    public Circle2D(double x, double y, double radius){
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public double getArea(){
        return Math.pow(radius, 2) * Math.PI;
    }
    
    public double getPerimeter(){
        return 2 * radius * Math.PI;
    }
     
    public boolean contains(double x, double y){
        double distance = Math.sqrt(Math.pow(this.y - y, 2) + Math.pow(this.x - x, 2));
        return distance < radius;
    }
    
    public boolean contains(Circle2D circle){
        double distanceOfCenters = Math.sqrt(Math.pow(this.y - circle.getY(), 2) + Math.pow(this.x - circle.getX(), 2));
        return distanceOfCenters + circle.getRadius() <= this.radius;
    }
    
    public boolean overlaps(Circle2D circle){
        double distanceOfCenters = Math.sqrt(Math.pow(this.y - circle.getY(), 2) + Math.pow(this.x - circle.getX(), 2));
        return distanceOfCenters <= this.radius + circle.getRadius();
    }
    
}
