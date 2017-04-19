package testmystack;

import java.util.ArrayList;

public class MyStack extends ArrayList {
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
}
