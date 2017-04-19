package testmyrectangle2d;

public class MyRectangle2D {
    private double x;
    private double y;
    private double width;
    private double height;
    
    public MyRectangle2D(){
        this(0, 0, 1, 1);
    }
    
    public MyRectangle2D(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public void setWidth(double width){
        this.width = width;
    }
    
    public void setHeight(double height){
        this.height = height;
    }
    
    public double getWidth(){
        return width;
    }
    
    public double getHeight(){
        return height;
    }
    
    public double getArea(){
        return width * height;
    }
    
    public double getPerimeter(){
        return 2 * (height + width);
    }
    
    public double getDistance(double p1, double p2){
        return Math.abs(p1 - p2);
    }
    
    public boolean contains(double x, double y){
        return (getDistance(this.y, y) < height / 2) &&
                (getDistance(this.x, x) < width / 2);
    }
    
    public boolean contains(MyRectangle2D r){
        return (getDistance(this.x, r.getX()) + r.getWidth() / 2 < this.width / 2) &&
                (getDistance(this.y, r.getY()) + r.getHeight() / 2 < this.height / 2);
    }
    
    public boolean overlaps(MyRectangle2D r){
        return (getDistance(this.x, r.getX()) < r.getWidth() / 2 + this.width / 2) &&
                (getDistance(this.y, r.getY()) < r.getHeight() / 2 + this.height / 2) &&
                (!contains(r)) &&
                (!((getDistance(this.x, r.getX()) + this.width / 2 < r.getWidth() / 2) &&
                   (getDistance(this.y, r.getY()) + this.height / 2 < r.getHeight() / 2)));
    }
}
