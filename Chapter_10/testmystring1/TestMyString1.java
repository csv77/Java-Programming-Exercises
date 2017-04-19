package testmystring1;

public class TestMyString1 {

    public static void main(String[] args) {
        char[] test = {'T', 'e', 'S', 't'};
        char[] test2 = {'T', 'e', 'S', 't', '2'};
        MyString1 str = new MyString1(test);
        MyString1 str2 = new MyString1(test2);
        System.out.println(str.charAt(3));
        System.out.println(str.length());
        MyString1 substr = str.substring(1, 3);
        for(int i = 0; i < substr.length(); i++){    
            System.out.print(substr.charAt(i));
        }
        System.out.println();
        for(int i = 0; i < str.length(); i++){    
            System.out.print(str.toLowerCase().charAt(i));
        }
        System.out.println();
        System.out.println(str.equals(str));
        System.out.println(str.equals(str2));
        MyString1 v = MyString1.valueOf(20);
        for(int i = 0; i < v.length(); i++){
            System.out.print(v.charAt(i));
        }
        System.out.println();
        
    }
    
}
