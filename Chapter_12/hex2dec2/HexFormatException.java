package hex2dec2;

public class HexFormatException extends NumberFormatException{
    private String hex;
    
    public HexFormatException(String hex) {
        super(hex + " is not a hexadecimal number.");
        this.hex = hex;
    }
    
    public String getHex(){
        return hex;
    }
    
}
