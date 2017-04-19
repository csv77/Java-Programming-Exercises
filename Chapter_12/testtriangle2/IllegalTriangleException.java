package testtriangle2;

public class IllegalTriangleException extends Exception{
    private double a;
    private double b;
    private double c;
    
    public IllegalTriangleException(double a, double b, double c){
        super("Cannot create triangle with these sides: " + a + ", " + b + ", " + c + ".");
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public double getSideA(){
        return a;
    }
    
    public double getSideB(){
        return b;
    }
    
    public double getSideC(){
        return c;
    }
    
}
