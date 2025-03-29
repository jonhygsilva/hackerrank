package com.coding.challenge.hackerrank;

// Java program to print all the combinations of balanced
// parenthesis.

import java.util.*;


class ColcheteCombination {
    // function which generates all possible n pairs of

    // balanced parentheses.

    // open : count of the number of open parentheses used

    // in generating the current string s. close : count of

    // the number of closed parentheses used in generating

    // the current string s. s : currently generated string/

    // ans : a vector of strings to store all the valid

    // parentheses.

    public static void generateParenthesis(int n, int open, int close, String s, ArrayList<String> ans) {
        if (open == n && close == n) {
            ans.add(s);
            return;
        }

        if (open < n) {
            generateParenthesis(n, open + 1, close, s + "{", ans);
        }

        if (close < open) {
            generateParenthesis(n, open, close + 1, s + "}", ans);

        }

    }


    public static void main(String[] args)

    {
        int n = 6;

        ArrayList<Integer> ans = new ArrayList<>();
        int[] ts;



    }
}


