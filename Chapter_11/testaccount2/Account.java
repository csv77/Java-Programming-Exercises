package testaccount2;

import java.util.ArrayList;
import java.util.Date;

public class Account{
    private String name;
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    private ArrayList<Transaction> transactions;
    
    public Account(){
        name = "";
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        dateCreated = new Date();
        transactions = new ArrayList<Transaction>();
    }
    public Account(int id, double balance){
        name = "";
        this.id = id;
        this.balance = balance;
        annualInterestRate = 0;
        dateCreated = new Date();
        transactions = new ArrayList<Transaction>();
    }
    
    public Account(String name, int id, double balance){
        this(id, balance);
        this.name = name;
    }
    
    public String getName(){
        return name;
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
    
    public void setName(String name){
        this.name = name;
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
        transactions.add(new Transaction('W', amount, balance, "Withdrawal from account"));
    }
    public void deposit(double amount){
        balance += amount;
        transactions.add(new Transaction('D', amount, balance, "Deposit to account"));
    }
    
    public ArrayList<Transaction> getTransaction(){
        return transactions;
    }
    
    @Override
    public String toString(){
        return "Account holder name: " + getName() +
               "\nInterest rate: " + getAnnualInterestRate() +
               "\nBalance: " + getBalance() +
               "\nAccount creation date: " + getDateCreated();
    }
}