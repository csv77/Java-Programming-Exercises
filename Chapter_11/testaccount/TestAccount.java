package testaccount;
import java.util.Date;

public class TestAccount {

    public static void main(String[] args) {
//        Account account = new Account(1122, 20000);
//        account.setAnnualInterestRate(4.5);
//        account.withdraw(2500);
//        account.deposit(3000);
//        System.out.println("Account ID: " + account.getId());
//        System.out.printf("Balance: $%.2f\n", account.getBalance());
//        System.out.printf("Monthly interest: $%.2f\n", account.getMonthlyInterest());
//        System.out.println("Account was created on " + account.getDateCreated());
        Account account = new Account(1122, 20000);
        SavingsAccount savings = new SavingsAccount(1004, 20000);
        CheckingAccount check = new CheckingAccount(1104, 20000, -20);
        
        account.setAnnualInterestRate(4.5);
        savings.setAnnualInterestRate(4.5);
        check.setAnnualInterestRate(4.5);
        
        account.withdraw(2500);
        savings.withdraw(2500);
        check.withdraw(2500);
        
        account.deposit(3000);
        savings.deposit(3000);
        check.deposit(3000);
        
        System.out.println(account.toString());
        System.out.println(savings.toString());
        System.out.println(check.toString());
        
    }
}

