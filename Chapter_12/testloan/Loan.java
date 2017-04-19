package testloan;

import java.util.Date;

public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    public Loan() {
        this(2.5, 1, 1000);
    }
    public Loan(double annualInterestRate, int numberOfYears,
        double loanAmount) throws IllegalArgumentException{
        if(annualInterestRate <= 0 || numberOfYears <= 0 || loanAmount <= 0){
            throw new IllegalArgumentException("Not valid data.");
        }
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new Date();
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) throws IllegalArgumentException{
        if(annualInterestRate <= 0){
            throw new IllegalArgumentException("Annual interest rate must be greater than 0.");
        }
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears) throws IllegalArgumentException{
        if(numberOfYears <= 0){
            throw new IllegalArgumentException("NumberOfYears must be greater than 0.");
        }
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) throws IllegalArgumentException{
        if(loanAmount <= 0){
            throw new IllegalArgumentException("LoanAmount must be greater than 0.");
        }
        this.loanAmount = loanAmount;
    }

    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
        (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }

    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }

    public Date getLoanDate() {
        return loanDate;
    }
}

