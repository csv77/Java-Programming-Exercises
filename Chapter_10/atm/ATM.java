package atm;
import testaccount.*;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Account[] account = initAccount(10);
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print("Enter an id: ");
            int id = input.nextInt();
            if(isValid(id, account)){
                int choice = printMenu(input);
                while(choice != 4){
                    if(isTransaction(choice)){
                        executeTransaction(choice, account[id], input);
                    }
                    choice = printMenu(input);
                }
            }
            System.out.println();
        }
    }
    
    public static Account[] initAccount(int number){
        Account[] account = new Account[10];
        for(int i = 0; i < number; i++){
            account[i] = new Account(i, 100);
        }
        return account;
    }
    
    public static int printMenu(Scanner input){
        System.out.println("\nMain menu");
        System.out.println("1: check balance");
        System.out.println("2: withdraw");
        System.out.println("3: deposit");
        System.out.println("4: exit");
        System.out.print("Enter a choice: ");
        return input.nextInt();
    }
    
    public static boolean isValid(int id, Account[] account){
        for(int i = 0; i < account.length; i++){
            if(id == account[i].getId()){
                return true;
            }
        }
        return false;
    }
    
    public static boolean isTransaction(int choice){
        return choice > 0 && choice < 4;
    }
    
    public static void executeTransaction(int choice, Account account, Scanner input){
        switch(choice){
            case 1 :
                System.out.println("The balance is " + account.getBalance());
                break;
            case 2 :
                System.out.print("Enter an amount to withdraw: ");
                account.withdraw(input.nextDouble());
                break;
            case 3 :
                System.out.print("Enter an amount to deposit: ");
                account.deposit(input.nextDouble());
                break;
        }
    }
    
}
