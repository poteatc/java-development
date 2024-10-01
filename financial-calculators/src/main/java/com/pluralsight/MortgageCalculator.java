package com.pluralsight;

public class MortgageCalculator {
    private int principal;
    private double monthlyInterestRate;
    private double yearlyInterestRate;
    private int loanLengthInMonths;

    /**
     * Contructs the Mortgage Calculator from inputs passed from Main.main()
     * @param principal
     * @param interestRate
     * @param loanLength
     */
    public MortgageCalculator(int principal, double interestRate, int loanLength) {
        this.principal = principal;
        this.yearlyInterestRate = interestRate / 100;
        this.monthlyInterestRate = yearlyInterestRate / 12;
        this.loanLengthInMonths = loanLength * 12;
    }

    /**
     * Returns the monthly payment from a mortgage
     * @return monthlyPayment
     */
    public double getMonthlyPayment() {
        double monthlyPayment = principal * (monthlyInterestRate / (1 - Math.pow((1 + monthlyInterestRate), -loanLengthInMonths)));
        return monthlyPayment;
    }

    /**
     * Returns the total amount of interest paid on top of the mortgage loan payments
     * @return totalInterestPaid
     */
    public double getTotalInterest() {
        double totalInterestPaid = (getMonthlyPayment() * loanLengthInMonths) - principal;
        return totalInterestPaid;
    }
}
