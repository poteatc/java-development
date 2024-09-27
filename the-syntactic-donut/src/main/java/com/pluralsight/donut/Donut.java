package com.pluralsight.donut;

import java.util.Scanner;

public class Donut {
    private static double price = .25;

    public static double getTotal(int numberOfDonuts) {
        return numberOfDonuts * price;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many donuts would you like?");

        //System.out.println("A dozen donuts cost $" + getTotal(12));
        //System.out.printf("A dozen donuts cost $%.2f", getTotal(120));
        int numDonuts = scanner.nextInt();
        scanner.nextLine();
        double total = getTotal(numDonuts);
        System.out.printf("%s donuts cost %.1s%.2f", numDonuts, "$$$$$$$$$", total);
        scanner.close();
    }
}
