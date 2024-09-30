package com.pluralsight.donut;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Donut {
    private static double price = .25;

    public static double getTotalPrice(int numberOfDonuts) {
        return numberOfDonuts * price;
    }

    public static void main(String[] args) {
//        System.out.println("How many donuts would you like?");
//
//        //System.out.println("A dozen donuts cost $" + getTotal(12));
//        //System.out.printf("A dozen donuts cost $%.2f", getTotal(120));
//        int numDonuts = scanner.nextInt();
//        scanner.nextLine();
//        double total = getTotalPrice(numDonuts);
//        System.out.printf("%s donuts cost %.1s%.2f", numDonuts, "$$$$$$$$$", total);
        Scanner scanner = new Scanner(System.in);
        int a = 0, b = 0;
        boolean redo = true;
        do {
            try {
                System.out.println("Enter an integer: ");
                a = scanner.nextInt();
                System.out.println("Enter another integer: ");
                b = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter integers...");
                scanner.next();
                continue;
            }
            int sum = a + b;
            System.out.println("The sum is: " + sum);
            redo = false;
        } while (redo);
        scanner.close();
    }
}
