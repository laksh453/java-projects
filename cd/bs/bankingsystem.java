package javaproject;

import java.util.Random;
import java.util.Scanner;

public class bankingsystem {
    private double balance = 0;

    // Deposit method
    public void deposit(double amt) {
        if (amt > 0) {
            balance = balance + amt;
            System.out.println("Deposited: " + amt);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdrawal method with OTP verification
    public void withdraw(double amt, Scanner sc) {
        if (amt > 0 && amt <= balance) {
            int generatedOtp = generateOTP();
            System.out.println("OTP sent: " + generatedOtp); 
            System.out.print("Enter OTP for withdrawal: ");
            int inputOtp = sc.nextInt();
            if (verifyOTP(generatedOtp, inputOtp)) {
                balance = balance - amt;
                System.out.println("Withdrawn: " + amt);
            } else {
                System.out.println("Transaction failed.");
            }
        } else {
            System.out.println("Insufficient balance");
        }
    }

    // Generate a random 6-digit OTP
    private int generateOTP() {
        Random rand = new Random();
        return 100000 + rand.nextInt(900000);
    }

    // Validate OTP
    private boolean verifyOTP(int actual, int entered) {
        return actual == entered;
    }

    // Display current balance
    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Main method to test the banking system
    public static void main(String[] args) {
        bankingsystem account = new bankingsystem();
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double wit = sc.nextDouble();
                    account.withdraw(wit, sc);
                    break;
                case 3:
                    account.displayBalance();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}