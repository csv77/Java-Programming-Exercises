package testarraylist2;

public class Circle {
	private double radius = 1;

	private static int numberOfObjects = 0;

	public Circle() {
		numberOfObjects++;
	}

	public Circle(double newRadius) {
		radius = newRadius;
		numberOfObjects++;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double newRadius) {
		radius = (newRadius >= 0) ? newRadius : 0;
	}

	public static int getNumberOfObjects() {
		return numberOfObjects;
	}

	public double getArea() {
		return radius * radius * Math.PI;
	}
        
        public String toString(){
            return "\nCircle with radius = " + getRadius();
        }
}
