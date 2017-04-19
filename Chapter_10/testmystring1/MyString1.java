package testmystring1;

public class MyString1 {
    private char[] chars;
    
    public MyString1(char[] chars){
        this.chars = new char[chars.length];
        for(int i  = 0; i < chars.length; i++){
            this.chars[i] = chars[i];
        }
    }
    
    public char charAt(int index){
        return chars[index];
    }
    
    public int length(){
        return chars.length;
    }
    
    public MyString1 substring(int begin, int end){
        char[] temp = new char[end - begin];
        for(int i = begin, j = 0; i < end; i++, j++){
            temp[j] = this.chars[i];
        }
        return new MyString1(temp);
    }
    
    public MyString1 toLowerCase(){
        char[] temp = new char[chars.length];
        for(int i = 0; i < chars.length; i++){
            if(chars[i] >= 'A' && chars[i] <= 'Z'){
                temp[i] = (char)(chars[i] + 32);
            }
            else{
                temp[i] = chars[i];
            }
        }
        return new MyString1(temp);
    }
    
    public boolean equals(MyString1 s){
        if(chars.length != s.length()){
            return false;
        }
        for(int i = 0; i < chars.length; i++){
            if(chars[i] != s.charAt(i)){
                return false;
            }
        }
        return true;
    }
    
    public static MyString1 valueOf(int i){
        int length = 0;
        int value = i;
        if(i == 0){
            length = 1;
        }
        while(value != 0){
            value /= 10;
            length++;
        }
        char[] chars = new char[length];
        for(int j = 0; j < length; j++){
            chars[length - j - 1] = (char)(i % 10 + 48);
            i /= 10;
        }
        return new MyString1(chars);
    }
    
}
