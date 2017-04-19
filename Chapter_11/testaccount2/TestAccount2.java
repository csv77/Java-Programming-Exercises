package testaccount2;

public class TestAccount2 {

    public static void main(String[] args) {
        Account account = new Account("George", 1122, 1000);
        account.setAnnualInterestRate(1.5);
        account.deposit(30);
        account.deposit(40);
        account.deposit(50);
        account.withdraw(5);
        account.withdraw(4);
        account.withdraw(7);
        System.out.println("\nAccount summary\n---------------");
        System.out.println(account.toString());
        System.out.println("\nList of transactions\n--------------------");
        for(int i = 0; i < account.getTransaction().size(); i++){
            System.out.println(account.getTransaction().get(i).toString());
        }
        
    }
    
}
