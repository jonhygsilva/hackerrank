package com.coding.challenge.hackerrank;

import java.util.*;

public class SubArraySumEqualsK {


    /*
        Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

        A subarray is a contiguous non-empty sequence of elements within an array.
        https://leetcode.com/problems/subarray-sum-equals-k/description/
     */


    public static int subarraySum(int[] nums, int k) {
        int sum = 0;

        for (int num = 0; num <= nums.length; num++) {
            int sumAux = 0;

            for (int j = num; j < nums.length; j++) {
                sumAux += nums[j];

                if (sumAux == k) {
                    sum++;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int k = 0;
        int[] nums = {1,-1,0};

        int sum = subarraySum(nums, k);

        System.out.println(sum);
    }
}
