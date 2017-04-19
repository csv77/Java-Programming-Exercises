package testarraylist2;

import java.util.ArrayList;
import java.util.Date;

public class TestArrayList2 {

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Loan());
        list.add(new Circle());
        list.add(new Date());
        list.add(new String("String class"));
        
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i).toString());
        }
        System.out.println(list.toString());
    }
    
}
