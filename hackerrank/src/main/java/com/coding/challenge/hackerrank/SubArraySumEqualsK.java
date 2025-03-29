package com.coding.challenge.hackerrank;

public class SubArraySumEqualsK {

    /*
        Problem: Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

        A subarray is a contiguous non-empty sequence of elements within an array.
        https://leetcode.com/problems/subarray-sum-equals-k/description/
     */

    /**
     * Function to count the number of subarrays whose sum equals to k.
     *
     * @param nums An array of integers.
     * @param k The target sum for the subarrays.
     * @return The number of subarrays whose sum equals to k.
     */
    public static int subarraySum(int[] nums, int k) {
        int sum = 0;

        // Outer loop: Start from each element
        for (int num = 0; num <= nums.length; num++) {
            int sumAux = 0;

            // Inner loop: Add elements one by one and check if their sum equals to k
            for (int j = num; j < nums.length; j++) {
                sumAux += nums[j];

                // If the sum of the current subarray equals to k, increment the count
                if (sumAux == k) {
                    sum++;
                }
            }
        }

        // Return the total number of subarrays whose sum is equal to k
        return sum;
    }

    public static void main(String[] args) {
        int k = 0;  // Target sum
        int[] nums = {1, -1, 0};  // Input array

        // Calculate the number of subarrays whose sum equals k
        int sum = subarraySum(nums, k);

        // Print the result
        System.out.println(sum);  // Expected output: 2
    }
}
