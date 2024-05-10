import java.util.*;
// import java.package_java.bank.bank.*;

public class bank_ {
    public static void main(String[] args) {
        int  balance = 0;
        int choice = 0;
        do {
            System.out.println(" Enter the number according to your choice\n" + "*******************************************\n" + "1. Show balance\n" + "2. Deposit money\n" + "3. Withdraw money\n" + "4. Exit\n");
            
            System.out.println("\nEnter your choice - ");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            scanner.close();

            switch (choice) {
                case 1:
                    balance(balance);
                    break;
                case 2:
                    deposit(balance);
                    break;
                case 3:
                    withdraw(balance);
                    break;
                case 4:
                    System.out.println("Thanks for visiting ");
                    break;
                default:
                System.out.println("Not a valid input ");
                    break;
            }

        } while (choice != 4);

    }
    static int balance(int balance){
        System.out.println(balance);
        return balance;
    }
    static int deposit(int balance){
        Scanner scanner = new Scanner(System.in);
        int deposit = scanner.nextInt();
        balance = balance + deposit;
        scanner.close();

        return balance;
    }
    static int withdraw(int balance){
        Scanner scanner = new Scanner(System.in);
        int withdraw = scanner.nextInt();
        balance = balance - withdraw;
        scanner.close();

        return balance;
    }
}
