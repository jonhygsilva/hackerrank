package com.coding.challenge.hackerrank;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    /*
        Given a string s, find the length of the longest substring without repeating characters.
        https://leetcode.com/problems/longest-substring-without-repeating-characters/
     */

    /**
     * Function to find the length of the longest substring without repeating characters.
     *
     * @param s The input string.
     * @return The length of the longest substring without repeating characters.
     */
    public static int lengthOfLongestSubstring(String s) {
        // HashSet to store the unique characters
        Set<Character> seen = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            // If the character is already in the set, remove characters from the left to make the substring unique
            while (seen.contains(s.charAt(right))) {
                seen.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set
            seen.add(s.charAt(right));

            // Calculate the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "dvdf";

        int result = lengthOfLongestSubstring(s);

        System.out.println("The length of the longest substring without repeating characters is: " + result);
    }
}
