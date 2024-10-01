package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        promptUser();

        // Gets user input to determine which calculator they want to use
        int input = 0;
        do {
            // checks for valid input and loops to ask again
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer");
                scanner.next();
                continue;
            }
            if (input == 1) {
                // Get the necessary inputs from user for mortgage calculations
                System.out.print("\nEnter the principal amount: $");
                int principal = scanner.nextInt();
                System.out.print("\nEnter the interest rate as a percentage: %");
                double interestRate = scanner.nextDouble();
                System.out.print("\nEnter the loan length in years(Integer): ");
                int loanLength = scanner.nextInt();

                // Instantiate the mortgageCalculator object with the given user input
                MortgageCalculator mortgageCalculator = new MortgageCalculator(principal, interestRate, loanLength);

                // Print out user inputs and final calculations
                System.out.printf("A $%d loan at %.3f%% interest for %d years would have a $%.2f/mo payment " +
                        "with a total interest of $%.2f",
                        principal, interestRate, loanLength, mortgageCalculator.getMonthlyPayment(), mortgageCalculator.getTotalInterest());
                System.out.println("\n\n");
            } else if (input == 2) {
                // Get the necessary inputs from user for a CD (certificate of deposit)
                System.out.print("\nEnter the deposit amount: $");
                int deposit = scanner.nextInt();
                System.out.print("\nEnter the annual interest rate as a percentage: %");
                double annualInterestRate = scanner.nextDouble();
                System.out.print("\nEnter the loan length in years: ");
                int loanLength = scanner.nextInt();

                // Instantiate the CDValueCalculator object with the given user input
                CDValueCalculator cdValueCalculator = new CDValueCalculator(deposit, annualInterestRate, loanLength);

                // Print out user inputs and final calculations
                System.out.printf("If you deposit $%d in a CD that earns %.2f%% interest and matures in " +
                        "%d years, your CD's ending balance will be $%.2f and you would have earned " +
                        "$%.2f in interest", deposit, annualInterestRate, loanLength, cdValueCalculator.getFutureValue(), cdValueCalculator.getInterestAccrued());
                System.out.println("\n\n");
            } else if (input == 3) {
                // Get the necessary inputs from user for an annuity
                System.out.println("Enter the monthly payout: ");
                int monthlyPayout = scanner.nextInt();
                System.out.println("Enter the expected interest rate: %");
                double interestRate = scanner.nextDouble();
                System.out.println("Enter the amount of years: ");
                int years = scanner.nextInt();

                // Instantiate an AnnuityCalculator object with the given user input
                AnnuityCalculator annuityCalculator = new AnnuityCalculator(monthlyPayout, interestRate, years);

                // Print out user inputs and final calculations
                System.out.printf("To fund an annuity that pays $%d monthly for %d years and earns" +
                        " an expected %.2f%% interest, you would need to invest $%.2f today."
                        , monthlyPayout, years, interestRate, annuityCalculator.getPresentValue());
                System.out.println("\n\n");
            } else if (input == 4) {
                // Exit if user enters the integer 4
                break;
            } else {
                // This case is when the user doesn't enter an integer between 1 and 4
                System.out.println("***Please enter a valid number***");
                continue;
            }
            promptUser();
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer");
                scanner.next();
            }
        } while (input != 4);
        System.out.println("Exiting calculator...");
    }

    // Calculator main menu
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
