package testmystring2;

public class MyString2 {
    private String s;
    
    public MyString2(String s){
        this.s = "";
        for(int i = 0; i < s.length(); i++){
            this.s += s.charAt(i);
        }
    }
    
    public int compare(String s){
        if(this.s.length() != s.length()){
            return this.s.length() - s.length();
        }
        for(int i = 0; i < this.s.length(); i++){
            if(this.s.charAt(i) != s.charAt(i)){
                return (int)(this.s.charAt(i) - s.charAt(i));
            }
        }
        return 0;
    }
    
    public MyString2 substring(int begin){
        String s2 = "";
        for(int i = begin; i < this.s.length(); i++){
            s2 += s.charAt(i);
        }
        return new MyString2(s2);
    }
    
    public MyString2 toUpperCase(){
        String s2 = "";
        for(int i = 0; i < this.s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                s2 += (char)(s.charAt(i) - 32);
            }
            else{
                s2 += s.charAt(i);
            }    
        }
        return new MyString2(s2);
    }
    
    public char[] toChars(){
        char[] c = new char[s.length()];
        for(int i = 0; i < s.length(); i++){
            c[i] = s.charAt(i);
        }
        return c;
    }

    public static MyString2 valueOf(boolean b){
        return b ? new MyString2("true") : new MyString2("false");
    }
}
