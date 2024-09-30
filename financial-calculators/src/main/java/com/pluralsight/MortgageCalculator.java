package com.pluralsight;

public class MortgageCalculator {
    private int principal;
    private double monthlyInterestRate;
    private double yearlyInterestRate;
    private int loanLengthInMonths;

    public MortgageCalculator(int principal, double interestRate, int loanLength) {
        this.principal = principal;
        this.yearlyInterestRate = interestRate / 100;
        this.monthlyInterestRate = yearlyInterestRate / 12;
        this.loanLengthInMonths = loanLength * 12;
    }

    public double getMonthlyPayment() {
        double monthlyPayment = principal * (monthlyInterestRate / (1 - Math.pow((1 + monthlyInterestRate), -loanLengthInMonths)));
        return monthlyPayment;
    }

    public double getTotalInterest() {
        double totalInterestPaid = (getMonthlyPayment() * loanLengthInMonths) - principal;
        return totalInterestPaid;
    }
}
