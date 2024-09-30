package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        promptUser();

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
                System.out.print("\nEnter the principal amount(Integer): $");
                int principal = scanner.nextInt();
                System.out.print("\nEnter the interest rate as a percentage(Double): %");
                double interestRate = scanner.nextDouble();
                System.out.print("\nEnter the loan length in years(Integer): ");
                int loanLength = scanner.nextInt();
                MortgageCalculator mortgageCalculator = new MortgageCalculator(principal, interestRate, loanLength);
                System.out.printf("A $%d loan at %.3f%% interest for %d years would have a $%.2f/mo payment " +
                        "with a total interest of $%.2f",
                        principal, interestRate, loanLength, mortgageCalculator.getMonthlyPayment(), mortgageCalculator.getTotalInterest());
//                System.out.printf("\nYour monthly payment is: $%.2f", mortgageCalculator.getMonthlyPayment());
//                System.out.printf("\nYour total interest paid is: $%.2f", mortgageCalculator.getTotalInterest());
                System.out.println("\n\n");
            } else if (input == 2) {
                System.out.print("\nEnter the deposit amount(Integer): $");
                int deposit = scanner.nextInt();
                System.out.print("\nEnter the annual interest rate as a percentage(Double): %");
                double annualInterestRate = scanner.nextDouble();
                System.out.print("\nEnter the loan length in years(Integer): ");
                int loanLength = scanner.nextInt();
                CDValueCalculator cdValueCalculator = new CDValueCalculator(deposit, annualInterestRate, loanLength);
                System.out.printf("If you deposit $%d in a CD that earns %.2f%% interest and matures in " +
                        "%d years, your CD's ending balance will be $%.2f and you would have earned " +
                        "$%.2f in interest", deposit, annualInterestRate, loanLength, cdValueCalculator.getFutureValue(), cdValueCalculator.getInterestAccrued());
                System.out.println("\n\n");
            } else if (input == 3) {
                System.out.println("Enter the monthly payout(Integer): ");
                int monthlyPayout = scanner.nextInt();
                System.out.println("Enter the expected interest rate(Double): %");
                double interestRate = scanner.nextDouble();
                System.out.println("Enter the amount of years(Integer): ");
                int years = scanner.nextInt();
                AnnuityCalculator annuityCalculator = new AnnuityCalculator(monthlyPayout, interestRate, years);
                System.out.printf("To fund an annuity that pays $%d monthly for %d years and earns" +
                        " an expected %.2f%% interest, you would need to invest $%.2f today."
                        , monthlyPayout, years, interestRate, annuityCalculator.getPresentValue());
                System.out.println();
            } else if (input == 4) {
                break;
            } else {
                System.out.println("Please enter a valid number!!!");
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
