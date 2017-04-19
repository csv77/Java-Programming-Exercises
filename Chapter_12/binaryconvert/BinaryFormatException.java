package binaryconvert;

public class BinaryFormatException extends NumberFormatException{
    private String binaryString;
    
    public BinaryFormatException(String binaryString){
        super(binaryString + " is not a binary number.");
        this.binaryString = binaryString;
    }
    
    public String getBinary(){
        return binaryString;
    }
}
