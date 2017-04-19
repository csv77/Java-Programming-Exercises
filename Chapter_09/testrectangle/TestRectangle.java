package testrectangle;

public class TestRectangle {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(4, 40);
        Rectangle r2 = new Rectangle(3.5, 35.9);
        System.out.println("The width of r1: " + r1.width + "\nthe height of r1: " + r1.height +
                           "\nthe area: " + r1.getArea() + "\nthe perimeter: " + r1.getPerimeter());
        System.out.println("The width of r2: " + r2.width + "\nthe height of r2: " + r2.height +
                           "\nthe area: " + r2.getArea() + "\nthe perimeter: " + r2.getPerimeter());
    }
}

class Rectangle{
    public double width = 1;
    public double height = 1;
    
    public Rectangle(){
    }
    
    public Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }
    
    public double getArea(){
        return width * height;
    }
    
    public double getPerimeter(){
        return 2 * (width + height);
    }
    
}