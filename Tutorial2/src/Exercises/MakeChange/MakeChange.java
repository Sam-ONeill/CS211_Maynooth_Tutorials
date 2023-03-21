package Exercises.MakeChange;

import java.util.Scanner;

abstract class Currency<T> {
    private T denomination;

    public Currency(T denomination) {
        this.denomination = denomination;
    }

    public T getDenomination() {
        return denomination;
    }
}

class Coin extends Currency<Double> {
    public Coin(Double denomination) {
        super(denomination);
    }
}

class Cash extends Currency<Integer> {
    public Cash(Integer denomination) {
        super(denomination);
    }
}

public class MakeChange {
    private static final Integer[] cashDenominations = {500, 200, 100, 50, 20, 10, 5};
    private static final Double[] coinDenominations = {2.0, 1.0, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount charged (in euros): ");
        double chargedAmount = scanner.nextDouble();
        System.out.print("Enter the amount given (in euros): ");
        double givenAmount = scanner.nextDouble();

        double changeAmount = givenAmount - chargedAmount;
        if (changeAmount < 0) {
            System.out.println("Insufficient amount given.");
        } else if (changeAmount == 0) {
            System.out.println("No change needed.");
        } else {
            System.out.println("Change amount: " + changeAmount + " euros");
            System.out.println("Change breakdown:");
            makeChange(changeAmount);
        }

        scanner.close();
    }

    /**
     * Computes the change breakdown using the fewest number of bills and coins.
     * changeAmount is The amount of change needed in euros.
     */
    private static void makeChange(double changeAmount) {
        // Convert the changeAmount from euros to cents to avoid floating-point errors
        int remainingChange = (int) (changeAmount * 100);

        // Iterate through cashDenominations (bills) to find the fewest number of bills needed
        for (Integer cashDenomination : cashDenominations) {
            Cash cash = new Cash(cashDenomination);

            // Calculate how many bills of the current denomination can be used
            int count = remainingChange / (cash.getDenomination() * 100);

            // If at least one bill of the current denomination can be used, print the count
            if (count > 0) {
                System.out.println(cash.getDenomination() + " euro bill(s): " + count);
                // Update the remaining change after using the current bills
                remainingChange %= (cash.getDenomination() * 100);
            }
        }

        // Iterate through coinDenominations to find the fewest number of coins needed
        for (Double coinDenomination : coinDenominations) {
            Coin coin = new Coin(coinDenomination);

            // Calculate how many coins of the current denomination can be used
            int count = (int) (remainingChange / (coin.getDenomination() * 100));

            // If at least one coin of the current denomination can be used, print the count
            if (count > 0) {
                System.out.println(coin.getDenomination() + " euro coin(s): " + count);
                // Update the remaining change after using the current coins
                remainingChange %= (int) (coin.getDenomination() * 100);
            }
        }
    }
}
