package testoctagon;

public class TestOctagon {

    public static void main(String[] args) throws CloneNotSupportedException {
        Octagon o1 = new Octagon(5);
        System.out.println(o1);
        Octagon o2 = o1.clone();
        System.out.println("Compare o1 and o2: " + (o1.compareTo(o2) == 0 ? "same areas" : "different areas"));
    }
    
}
