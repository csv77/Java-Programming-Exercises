package exercise_25_03;

public class Exercise_25_03 {

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.add(15);
        tree.add(10);
        tree.add(8);
        tree.add(12);
        tree.add(20);
        tree.add(18);
        tree.add(25);
        
        tree.nonRecursiveInorder();
    }
}
