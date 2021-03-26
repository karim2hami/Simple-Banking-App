package BankingApp;

import java.util.Scanner;

public class Account {

    private String firstName;
    private String lastName;
    private String userID;
    private double balance;
    private double interestRate = 5.5;
    private int userInput;
    private double previousTransaction;


    public Account(String firstName, String lastName, String userID) {
        System.out.println("Welcome, " + firstName + " " + lastName);
        System.out.println("Your Account ID is: " + userID);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userID;

        showMenu();
    }

    void showMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("1. Check your balance");
        System.out.println("2. Make a deposit");
        System.out.println("3. Make a withdrawal");
        System.out.println("4. View previous transaction");
        System.out.println("5. Calculate interest");
        System.out.println("6. Exit the application");

        do {
            System.out.println();
            System.out.print("Enter an option: ");
            int userInput = scanner.nextInt();

            if (userInput == 1) {
                checkBalance();
            } else if (userInput == 2) {
                deposit();
            } else if (userInput == 3) {
                withdrawal();
            } else if (userInput == 4) {
                viewPreviousTransaction();
            } else if (userInput == 5) {
                calculateInterest();
            } else if (userInput == 6) {
                exit();
                break;
            }
        } while(userInput != 6);
    }

    public void checkBalance() {
        System.out.println("=====================================");
        System.out.println("Your current balance is: $" + balance);
        System.out.println("=====================================");
    }

    public void deposit() {
        System.out.print("Enter amount to deposit: $");
        Scanner scanner = new Scanner(System.in);
        int depositAmount = scanner.nextInt();
        balance = balance + depositAmount;
        previousTransaction = +depositAmount;
        System.out.println("=====================================");
        System.out.println("Your new balance is: $" + balance);
        System.out.println("=====================================");
    }

    public void withdrawal() {
        System.out.print("Enter amount to withdrawal: $");
        Scanner scanner = new Scanner(System.in);
        int withdrawalAmount = scanner.nextInt();
        balance = balance - withdrawalAmount;
        previousTransaction = -withdrawalAmount;
        System.out.println("=====================================");
        System.out.println("Your new balance is: $" + balance);
        System.out.println("=====================================");
    }

    public void viewPreviousTransaction(){
        if(previousTransaction > 0) {
            System.out.println("Deposited: $" + previousTransaction);
        } else if(previousTransaction < 0) {
            System.out.println("Withdrawn: $" + previousTransaction);
        } else {
            System.out.println("No transaction has been made!");
        }
    }

    public void calculateInterest() {
        System.out.println("Your current interestrate is: " + interestRate + "%");
        System.out.print("Enter the amount you want to invest: $");
        Scanner scanner = new Scanner(System.in);
        double interestAmount = scanner.nextInt();
        System.out.print("Next enter the amount of years you want to invest: ");
        Scanner scanner1 = new Scanner(System.in);
        double investYears = scanner1.nextInt();
        double investmentReturns = interestAmount * interestRate * investYears;
        System.out.println("Your estimated return on investment is:  $" + investmentReturns);
    }

    public void exit() {
        System.out.println("Thank you for banking with us!\nHave a nice day " + firstName + " " + lastName);
    }

}
