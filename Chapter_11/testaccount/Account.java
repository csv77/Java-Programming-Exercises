package testaccount;

import java.util.Date;

public class Account{
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    
    public Account(){
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
    }
    public Account(int id, double balance){
        this.id = id;
        this.balance = balance;
        annualInterestRate = 0;
        dateCreated = new Date();
    }
    
    public int getId(){
        return id;
    }
    public double getBalance(){
        return balance;
    }
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    public String getDateCreated(){
        return dateCreated.toString();
    }
    public void setId(int id){
        this.id = id;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }
    public double getMonthlyInterestRate(){
        return annualInterestRate / 12;
    }
    public double getMonthlyInterest(){
        return balance * (getMonthlyInterestRate() / 100);
    }
    public void withdraw(double amount){
        balance -= amount;
    }
    public void deposit(double amount){
        balance += amount;
    }
    
    @Override
    public String toString(){
        return "\nAccount ID: " + getId() + "\nDate created: " + getDateCreated() +
               "\nAccount balance: $" + String.format("%.2f", getBalance()) +
               "\nMonthly interest: $" + String.format("%.2f", getMonthlyInterest());
                
    }
}