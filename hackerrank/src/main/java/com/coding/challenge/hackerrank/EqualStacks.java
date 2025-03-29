package com.coding.challenge.hackerrank;

import java.util.List;

public class EqualStacks {

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        int sizeH1 = getSum(h1);
        int sizeH2 = getSum(h2);
        int sizeH3 = getSum(h3);
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;


        while((sizeH1 != sizeH3) || (sizeH2 != sizeH3)) {
            if(sizeH1 > sizeH2) {
                sizeH1 -= h1.get(i1);
                i1++;
            } else if (sizeH2 > sizeH1) {
                sizeH2 -= h2.get(i2);
                i2++;
            }

            if(sizeH1 > sizeH3) {
                sizeH1 -= h1.get(i1);
                i1++;
            } else if (sizeH3 > sizeH1) {
                sizeH3 -= h3.get(i3);
                i3++;
            }

            if(sizeH2 > sizeH3) {
                sizeH2 -= h2.get(i2);
                i2++;
            } else if (sizeH3 > sizeH2) {
                sizeH3 -= h3.get(i3);
                i3++;
            }

        }

        return sizeH3;


    }


    public static int getSum(List<Integer> height) {
        return height.stream().reduce(0, Integer::sum);
    }
}
