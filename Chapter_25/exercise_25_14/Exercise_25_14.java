package exercise_25_14;

import exercise_20_21.Circle;
import exercise_20_21.GeometricObject;
import exercise_20_21.GeometricObjectComparator;
import exercise_20_21.Rectangle;

public class Exercise_25_14 {

    public static void main(String[] args) {
        BST<GeometricObject> tree = new BST(new GeometricObjectComparator());
        
        tree.add(new Circle(5));
        tree.add(new Circle(10));
        tree.add(new Rectangle(10, 10));
        
        tree.inorder();
    }
}
