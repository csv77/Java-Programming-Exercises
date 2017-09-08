package exercise_27_09;

public class Exercise_27_09 {

    public static void main(String[] args) {
        System.out.println("Hash code of \"ant\" is: " + hashCodeForString("ant"));
    }
    
    public static int hashCodeForString(String s) {
        int b = 31;
        int hashCode = 0;
        
        for(int i = 0; i < s.length(); i++) {
            hashCode = hashCode * b + (int)s.charAt(i);
        }
        
        return hashCode;
    }
}
