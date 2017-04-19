package testmystring2;

public class TestMyString2 {

    public static void main(String[] args) {
        MyString2 str = new MyString2("alma");
        System.out.println(str.compare("alm"));
        System.out.println(str.substring(2).toChars());
        System.out.println(str.toUpperCase().toChars());
        System.out.println(MyString2.valueOf(true).toChars());
        
    }
    
}
