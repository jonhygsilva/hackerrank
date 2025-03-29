package com.coding.challenge.hackerrank;

import java.util.List;

public class StockMaximize {

    /**
     * Problem: Maximize profit by buying and selling stock at the best times.
     *
     * Given a list of stock prices where each element is the price of the stock on a given day,
     * the goal is to determine the maximum profit possible by buying and selling stock multiple times.
     * You can buy on any day and sell on any subsequent day.
     *
     * Input:
     * - A list of integers representing stock prices on consecutive days.
     *
     * Output:
     * - The maximum profit you can earn.
     *
     * Example:
     * Input: [1, 2, 100, 50, 120]
     * Output: 219
     */

    public static long stockmax(List<Integer> prices) {
        // Initialize the last day as the maximum price
        int max = prices.size() - 1;
        long profit = 0L;

        // Traverse the prices from the second-to-last day to the first day
        for (int i = max - 1; i >= 0; i--) {
            Integer iValue = prices.get(i);
            Integer maxValue = prices.get(max);

            // If the current price is less than the maximum price found after it, calculate profit
            if (iValue < maxValue) {
                profit += (maxValue - iValue);
            } else {
                // If the price is higher, update the max value (selling price)
                max = i;
            }
        }

        return profit;
    }
}
