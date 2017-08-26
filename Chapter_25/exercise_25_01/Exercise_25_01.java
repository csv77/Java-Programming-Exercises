package exercise_25_01;

public class Exercise_25_01 {

    public static void main(String[] args) {
        BST<String> tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");
        
        tree.breadthFirstTraversal();
        System.out.println("The height of tree is " + tree.height());
    }
}
