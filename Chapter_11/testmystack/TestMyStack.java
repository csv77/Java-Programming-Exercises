package testmystack;

import java.util.Scanner;

public class TestMyStack {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MyStack mystack = new MyStack();
        for(int i = 0; i < 5; i++){
            mystack.push(input.nextInt());
        }
        System.out.println(mystack.toString());
        mystack.pop();
        System.out.println(mystack.toString());
        
    }
    
}
