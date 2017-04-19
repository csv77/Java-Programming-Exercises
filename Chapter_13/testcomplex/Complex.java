package testcomplex;

public class Complex implements Cloneable{
    private double a;
    private double b;
    
    public Complex() {
        this(0, 0);
    }
    
    public Complex(double a) {
        this(a, 0);
    }
    
    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }
    
    public double getRealPart() {
        return a;
    }
    
    public double getImaginaryPart() {
        return b;
    }
    
    public Complex add(Complex secondComplex) {
        return new Complex(this.a + secondComplex.a, this.b + secondComplex.b);
    }
    
    public Complex subtract(Complex secondComplex) {
        return new Complex(this.a - secondComplex.a, this.b - secondComplex.b);
    }
    
    public Complex multiply(Complex secondComplex) {
        return new Complex(this.a * secondComplex.a - this.b * secondComplex.b, this.b * secondComplex.a + this.a * secondComplex.b);
    }
    
    public Complex divide(Complex secondComplex) {
        return new Complex((this.a * secondComplex.a + this.b * secondComplex.b) / (Math.pow(secondComplex.a, 2) + Math.pow(secondComplex.b, 2)),
                            (this.b * secondComplex.a - this.a * secondComplex.b) / (Math.pow(secondComplex.a, 2) + Math.pow(secondComplex.b, 2)));
    }
    
    public double abs() {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }
    
    @Override
    public String toString() {
        return b == 0 ? "" + a : "(" + a + " + " + b + "i)";
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return (Complex)super.clone();
    }
}
