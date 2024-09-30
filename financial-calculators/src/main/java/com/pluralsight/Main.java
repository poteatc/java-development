package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        System.out.println("-".repeat(15));
//        System.out.println("...Welcome to the calculator menu...\n--Please select what you would like to calculate--");
//        System.out.println("1) Monthly payment for a mortgage");
//        System.out.println("2) The future value of a one-time deposit with compound interest");
//        System.out.println("3) The present value of an ordinary annuity");
//        System.out.println("4) EXIT");
//        System.out.println("Enter 1, 2, 3, or 4:");
//        System.out.println("-".repeat(15));
        promptUser();

        //int input = scanner.nextInt();
        int input = 0;
        do {
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer");
                scanner.next();
                continue;
            }
            if (input == 1) {
                System.out.print("\nEnter the principal amount: ");
                int principal = scanner.nextInt();
                System.out.print("\nEnter the interest rate as a percentage: ");
                double interestRate = scanner.nextDouble();
                System.out.print("\nEnter the loan length in years: ");
                int loanLength = scanner.nextInt();
                MortgageCalculator mortgageCalculator = new MortgageCalculator(principal, interestRate, loanLength);
                System.out.printf("\nYour monthly payment is: $%.2f", mortgageCalculator.getMonthlyPayment());
                System.out.printf("\nYour total interest paid is: $%.2f", mortgageCalculator.getTotalInterest());
                System.out.println("\n\n");
            } else if (input == 2) {
                System.out.print("\nEnter the deposit amount: ");
                int deposit = scanner.nextInt();
                System.out.print("\nEnter the annual interest rate as a percentage: ");
                double annualInterestRate = scanner.nextDouble();
                System.out.print("\nEnter the loan length in years: ");
                int loanLength = scanner.nextInt();
                CDValueCalculator cdValueCalculator = new CDValueCalculator(deposit, annualInterestRate, loanLength);
                System.out.printf("\nYour monthly payment is: $%.2f\n", cdValueCalculator.getFutureValue());
                System.out.printf("\nThe total interest you earned is: $%.2f\n", cdValueCalculator.getInterestAccrued());
                System.out.println("\n\n");
            } else if (input == 3) {

            } else if (input == 4) {
                break;
            } else {
                System.out.println("Please enter a valid number!!!");
                continue;
            }
            //System.out.println("Enter 1, 2, 3, or 4:");
            promptUser();
            input = scanner.nextInt();
        } while (input != 4);
        System.out.println("Exiting calculator...");
    }

    private static void promptUser() {
        System.out.println("*".repeat(40));
        System.out.println("...Welcome to the calculator menu...");
        System.out.println("-".repeat(40));
        System.out.print("Please select what you would like to calculate: ");
        System.out.println("\n1) Monthly payment for a mortgage");
        System.out.println("2) The future value of a one-time deposit with compound interest");
        System.out.println("3) The present value of an ordinary annuity");
        System.out.println("4) EXIT");
        System.out.println("*".repeat(40));
        System.out.println("Enter 1, 2, 3, or 4:");

    }
}
