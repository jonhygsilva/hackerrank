package com.coding.challenge.hackerrank;

import java.util.*;

public class LongestSubstringWithoutRepeatinCharacters {


    /*
        Given a string s, find the length of the longest substring without repeating characters.
       https://leetcode.com/problems/longest-substring-without-repeating-characters/
     */


    public static int lengthOfLongestSubstring(String s) {
        List<String> listS = Arrays.asList(s.split(""));
        List<Integer> ass = new ArrayList<>();

        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        for (int i = 0; i < listS.size(); i++) {
            boolean k = true;
            int j = i;
            List<String> auxList = new ArrayList<>();

            while (k && j < listS.size()){
                String sAux = listS.get(j);
                j++;

                if (auxList.contains(sAux)) {
                    k = false;
                    ass.add(auxList.size());
                } else {
                    auxList.add(sAux);

                    if (j == listS.size()) {
                        ass.add(auxList.size());
                    }
                }
            }
        }

        return Collections.max(ass);
    }

    public static void main(String[] args) {
        String s = "dvdf";

        int sum = lengthOfLongestSubstring(s);

        System.out.println(sum);
    }
}
