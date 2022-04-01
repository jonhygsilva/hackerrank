package com.coding.challenge.hackerrank;

import java.util.List;

public class StockMaximize {

    public static long stockmax(List<Integer> prices) {
        // Write your code here
        int max = prices.size() -1;
        long profit = 0L;

        for(int i = max - 1; i >= 0; i--) {
            Integer iValue = prices.get(i);
            Integer maxValue = prices.get(max);

            if(iValue < maxValue) {
                profit += (maxValue - iValue);
            } else {
                max = i;
            }
        }

        return profit;
    }
}
