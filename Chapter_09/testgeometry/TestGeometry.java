package testgeometry;

public class TestGeometry {

    public static void main(String[] args) {
        RegularPolygon polygon1 = new RegularPolygon();
        RegularPolygon polygon2 = new RegularPolygon(6, 4);
        RegularPolygon polygon3 = new RegularPolygon(10, 4, 5.6, 7.8);
        System.out.println("\t\tPerimeter\tArea");
        System.out.printf("Polyon1:\t%.3f\t\t%.3f\n", polygon1.getPerimeter(), polygon1.getArea());
        System.out.printf("Polyon1:\t%.3f\t\t%.3f\n", polygon2.getPerimeter(), polygon2.getArea());
        System.out.printf("Polyon1:\t%.3f\t\t%.3f\n", polygon3.getPerimeter(), polygon3.getArea());
    }
}

class RegularPolygon{
    private int n;
    private double side;
    private double x;
    private double y;
    
    RegularPolygon(){
        n = 3;
        side = 1;
        x = 0;
        y = 0;
    }
    RegularPolygon(int n, double side){
        this.n = n;
        this.side = side;
        x = 0;
        y = 0;
    }
    RegularPolygon(int n, double side, double x, double y){
        this.n = n;
        this.side = side;
        this.x = x;
        this.y = y;
    }
    
    public int getN(){
        return n;
    }
    public double getSide(){
        return side;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void setN(int n){
        this.n = n;
    }
    public void setSide(double side){
        this.side = side;
    }
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public double getPerimeter(){
        return n * side;
    }
    public double getArea(){
        return n * Math.pow(side, 2) / (4 * Math.tan(Math.PI / n));
    }
    
    
}
