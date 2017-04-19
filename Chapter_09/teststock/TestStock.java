package teststock;

public class TestStock {

    public static void main(String[] args) {
        Stock s1 = new Stock("ORCL", "Oracle Corporation");
        s1.previousClosingPrice = 34.5;
        s1.currentPrice = 34.35;
        System.out.println(s1.symbol + " " + s1.name);
        System.out.printf("The change of price is %6.3f %%\n", s1.getChangePercent());
    }
    
}

class Stock{
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;
    
    public Stock(String symbol, String name){
        this.symbol = symbol;
        this.name = name;
    }
    
    public double getChangePercent(){
        return (currentPrice - previousClosingPrice) / previousClosingPrice * 100;
    }
}
