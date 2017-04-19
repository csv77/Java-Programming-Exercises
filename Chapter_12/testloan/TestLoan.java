package testloan;

import java.util.Scanner;

public class TestLoan {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean correct = true;
        while(correct){
            System.out.println("Enter the number of years: ");
            int years = input.nextInt();
            System.out.println("Enter the loan amount: ");
            double amount = input.nextDouble();
            System.out.println("Enter the annual interest rate: ");
            double annualInterestRate = input.nextDouble();
            try {
                Loan loan = new Loan(annualInterestRate, years, amount);
                correct = false;
                System.out.printf("The loan was created on %s\nThe monthly payment is %.2f\nThe total payment is %.2f\n",
					loan.getLoanDate().toString(), loan.getMonthlyPayment(),
					loan.getTotalPayment());
            }
            catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
