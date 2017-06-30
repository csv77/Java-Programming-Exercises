package exercise_19_01;

public class Exercise_19_01 {

    public static void main(String[] args) {
        GenericStack<Integer> integerStack = new GenericStack<>();
        GenericStack<String> stringStack = new GenericStack<>();
        
        for(int i = 0; i < 15; i++) {
            integerStack.push(i * 5);
        }
        
        stringStack.push("Berlin");
        stringStack.push("Dresden");
        stringStack.push("München");
        System.out.println(stringStack.toString());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.toString());
        System.out.println("Stack size: " + stringStack.getSize());
        System.out.println("Stack empty: " + stringStack.isEmpty());
        
        System.out.println(integerStack.toString());
        integerStack.peek();
        integerStack.toString();
        System.out.println(integerStack.pop());
        System.out.println(integerStack.pop());
        System.out.println(integerStack.pop());
        System.out.println(integerStack.toString());
        
    }
}
