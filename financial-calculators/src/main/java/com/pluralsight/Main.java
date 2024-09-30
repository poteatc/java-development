package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("...Welcome to the calculator menu...\n--Please select what you would like to calculate--");
        System.out.println("1) Monthly payment for a mortgage");
        System.out.println("2) The future value of a one-time deposit with compound interest");
        System.out.println("3) The present value of an ordinary annuity");
        System.out.println("Enter 1, 2, or 3:");

        int input = scanner.nextInt();
        if (input == 1) {
            System.out.print("\nEnter the principal amount: ");
            int principal = scanner.nextInt();
            System.out.print("\nEnter the interest rate as a percentage: ");
            double interestRate = scanner.nextDouble();
            System.out.print("\nEnter the loan length in years: ");
            int loanLength = scanner.nextInt();
            MortgageCalculator mortgageCalculator = new MortgageCalculator(principal, interestRate, loanLength);
            System.out.printf("\nYour monthly payment is: %.2f", mortgageCalculator.getMonthlyPayment());
            System.out.printf("\nYour total interest paid is: %.2f", mortgageCalculator.getTotalInterest());
        }

    }


}
