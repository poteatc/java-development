package com.pluralsight;

public class CDValueCalculator {

    private int deposit;
    private double annualInterestRate;
    private int years;
    private int numberOfCompoundsPerYear;

    public CDValueCalculator(int deposit, double annualInterestRate, int years) {
        this.deposit = deposit;
        this.annualInterestRate = annualInterestRate / 100;
        this.years = years;
        this.numberOfCompoundsPerYear = years * 365;
    }

    /*
    A = P(1+r/n)^(nt)
        A is the total that your CD will be worth at the end of the term, including the amount you put in.
        P is the principal, or the amount you deposited when you bought the CD.
        R is the rate, or annual interest rate, expressed as a decimal. If the interest rate is 1.25% APY, r is 0.0125.
        n is the number of times that interest in compounded every year. Most CDs pay interest that is compounded daily, so n = 365.
            Check with your bank to verify the interest is compounded daily.
        t is time, or the number of years until the maturity date.
     */

    public double getFutureValue() {
        double futureValue = deposit * Math.pow((1 + annualInterestRate / numberOfCompoundsPerYear), numberOfCompoundsPerYear * years);
        return futureValue;
    }

    public double getInterestAccrued() {
        return getFutureValue() - deposit;
    }
}
