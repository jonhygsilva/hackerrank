package com.coding.challenge.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Waiter {
    //waiter hackerrank
    public static List<Integer> waiter(List<Integer> numbers, int q) {
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>(numbers);
        List<Integer> auxList = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        List<Integer> primeNumbers = primeNumbersTill(10000);

        for (int i = 0; i < q; i++) {
            for (int j = bList.size() -1; j >= 0; j--) {
                Integer bNumber = bList.get(j);
                if (bNumber%primeNumbers.get(i) == 0) {
                    aList.add(bList.get(j));
                } else {
                    auxList.add(bList.get(j));
                }
            }

            bList.clear();
            bList.addAll(auxList);
            Collections.reverse(aList);
            answer.addAll(aList);
            aList.clear();
            auxList.clear();
        }

        Collections.reverse(bList);
        answer.addAll(bList);
        return  answer;
    }

    public static List<Integer> primeNumbersTill(int n) {
        return IntStream.rangeClosed(2, n)
                .filter(Waiter::isPrime).boxed()
                .collect(Collectors.toList());
    }
    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }
}
