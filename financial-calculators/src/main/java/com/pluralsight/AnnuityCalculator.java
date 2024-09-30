package com.pluralsight;

public class AnnuityCalculator {
    private int monthlyPayout;
    private double yearlyInterestRate;
    private int years;
    private double monthlyInterestRate;
    private int numberOfPeriods;

    public AnnuityCalculator(int monthlyPayout, double interestRate, int years) {
        this.monthlyPayout = monthlyPayout;
        this.yearlyInterestRate = interestRate / 100;
        this.years = years;
        this.numberOfPeriods = years * 12;
        this.monthlyInterestRate = yearlyInterestRate / 12;
    }

    public double getPresentValue() {
        double presentValue = monthlyPayout * ((1 - Math.pow(1 + monthlyInterestRate, -numberOfPeriods)) / monthlyInterestRate);
        return presentValue;
    }
}
