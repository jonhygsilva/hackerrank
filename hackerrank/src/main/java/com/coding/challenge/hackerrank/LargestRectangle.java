package com.coding.challenge.hackerrank;

import java.util.List;

class LargestRectangle {
    // largest rectangle hackerrank
    public static long largestRectangle(List<Integer> h) {
        long size = h.size();
        long max = 0;

        for (int i = 0; i < size; i++) {
            long w = 1;
            Integer is = h.get(i);

            for (int j = i + 1; j < size; j++) {
                if (is > h.get(j)) {
                    break;
                }
                w++;
            }

            for (int j = i - 1; j >= 0; j--) {
                if (is > h.get(j)) {
                    break;
                }
                w++;
            }

            long sum = w * is;
            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }
}