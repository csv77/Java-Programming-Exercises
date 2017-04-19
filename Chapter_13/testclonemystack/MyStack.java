package testclonemystack;

import java.util.ArrayList;

public class MyStack implements Cloneable{
    private ArrayList<Object> list;
    
    public MyStack(){
        list = new ArrayList<>();
    }
    
    public Object peek(){
        return list.get(list.size() - 1);
    }    
    
    public Object pop(){
        Object a = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return a;
    }
    
    public void push(Object a){
        list.add(a);
    }
    
    @Override
    public String toString(){
        return "stack: " + list.toString();
    }
    
    @Override
    public Object clone() {
        try{    
            MyStack stackClone = (MyStack)super.clone();
            stackClone.list = (ArrayList<Object>)list.clone();
            return stackClone;
        }
        catch (CloneNotSupportedException ex) {
            System.out.println("CloneNotSupported Exception thrown");
            return null;
        }
    }
}

