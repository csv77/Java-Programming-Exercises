package exercise_27_03;

public class Exercise_27_03 {

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("Smith", 30);
        map.put("Anderson", 31);
        map.put("Lewis", 29);
        map.put("Cook", 29);
        map.put("Smith", 65);
        map.put("Coo", 22);
        
        System.out.println("Entries in map: " + map);
        
        System.out.println("The age for Lewis is " + map.get("Lewis"));
        
        System.out.println("Is Smith in the map? " + map.containsKey("Smith"));
        
        System.out.println("Is age 33 in the map? " + map.containsValue(33));
        
        System.out.print("Values in the map: ");
        for(Integer i : map.values()) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        map.remove("Smith");
        System.out.println("Entries in map: " + map);
        
        System.out.print("Values in the map: ");
        for(Integer i : map.values()) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        map.clear();
        System.out.println("Entries in map: " + map);
    }
}
