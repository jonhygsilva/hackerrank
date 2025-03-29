package com.coding.challenge.hackerrank;

import java.util.List;
import java.util.Stack;
import java.util.Arrays;

class LargestRectangle {

    /**
     * Problem: Find the largest rectangle in a histogram.
     *
     * You are given a histogram represented by a list of integers, where each integer represents
     * the height of a bar in the histogram. The width of each bar is assumed to be 1.
     *
     * The task is to find the area of the largest rectangle that can be formed by using any contiguous
     * subset of the bars. The area of a rectangle is determined by the height of the shortest bar in
     * the subset, and the width is determined by the number of bars included in the subset.
     *
     * The algorithm should return the maximum area of any rectangle that can be formed from the histogram.
     *
     * Input:
     * - A list of integers `h` representing the heights of the bars in the histogram.
     *
     * Output:
     * - A long integer representing the area of the largest rectangle that can be formed.
     *
     * Example:
     * Input: [2, 1, 5, 6, 2, 3]
     * Output: 10
     * Explanation:
     * The largest rectangle can be formed using the bars with heights 5 and 6, with width 2, giving an area of 10.
     */

    /**
     * Function to calculate the largest rectangle area in the histogram.
     *
     * @param heights A list of integers representing the heights of the bars in the histogram.
     * @return A long integer representing the area of the largest rectangle.
     */
    public static long largestRectangle(List<Integer> heights) {
        int size = heights.size();
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;

        // Traverse all bars of the histogram
        for (int i = 0; i < size; i++) {
            // While the current bar is shorter than the bar at the top of the stack, calculate the area
            while (!stack.isEmpty() && heights.get(stack.peek()) > heights.get(i)) {
                int height = heights.get(stack.pop());
                // Width is determined by the difference between current index and the index on top of the stack
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                // Calculate the area and update the maxArea if necessary
                maxArea = Math.max(maxArea, (long) height * width);
            }
            // Push the current index onto the stack
            stack.push(i);
        }

        // Calculate area for remaining bars in the stack
        while (!stack.isEmpty()) {
            int height = heights.get(stack.pop());
            int width = stack.isEmpty() ? size : size - stack.peek() - 1;
            maxArea = Math.max(maxArea, (long) height * width);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // Example input: A histogram with the bars of heights [2, 1, 5, 6, 2, 3]
        List<Integer> heights = Arrays.asList(2, 1, 5, 6, 2, 3);

        // Calling the method to find the largest rectangle area
        long maxRectangleArea = largestRectangle(heights);

        // Output the result
        System.out.println("The area of the largest rectangle is: " + maxRectangleArea);
    }
}
