package testclonemystack;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestCloneMyStack {

    public static void main(String[] args) {
        MyStack stack1 = new MyStack();
        stack1.push(5);
        stack1.push(3);
        stack1.push(10);
        MyStack stack2 = (MyStack)stack1.clone();
        stack1.pop();
        System.out.println(stack1);
        System.out.println(stack2);
    }
}
