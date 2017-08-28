package exercise_25_03;

public class Exercise_25_03 {

    public static void main(String[] args) {
        Integer[] array = {15, 10, 8, 12, 20, 18, 25, 32, 0, -2};
        BST<Integer> tree = new BST<>(array);
        
        tree.nonRecursiveInorder();
    }
}
