package testcolorablesquare;

public class TestColorableSquare {

    public static void main(String[] args) {
        GeometricObject[] squares = {new Square(5), new Square(4.5), new Square(2.1), new Square(10.8), new Square(3.9)};
        for(int i = 0; i < squares.length; i++) {
            System.out.println("Square #" + (i + 1));
            System.out.printf("Area: %.2f\n", squares[i].getArea());
            System.out.print("How to color: ");
            ((Square)squares[i]).howToColor();
        }
        
    }
    
}
