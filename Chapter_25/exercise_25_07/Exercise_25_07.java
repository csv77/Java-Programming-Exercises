package exercise_25_07;

public class Exercise_25_07 {

    public static void main(String[] args) {
        Integer[] array = {60, 55, 100, 45, 57, 67, 107, 101, 109, 59};
        BST<Integer> tree = new BST<>(array);
        System.out.println("Number of nonleaves: " + tree.getNumberOfNonLeaves());
    }
}
