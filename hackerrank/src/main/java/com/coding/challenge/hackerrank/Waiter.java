package com.coding.challenge.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Waiter {
    // Hackerrank waiter problem
    /**
     * This method separates the numbers into two lists based on divisibility by the first q prime numbers.
     * @param numbers List of integers
     * @param q Number of primes to divide the numbers by
     * @return A list where the numbers are organized first by divisibility with primes, then the rest.
     */
    public static List<Integer> waiter(List<Integer> numbers, int q) {
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>(numbers);
        List<Integer> auxList = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        // Generate list of primes until a large number
        List<Integer> primeNumbers = primeNumbersTill(10000);

        // Perform q iterations to separate numbers by divisibility with primes
        for (int i = 0; i < q; i++) {
            // Check for divisibility and separate numbers
            for (int j = bList.size() - 1; j >= 0; j--) {
                Integer bNumber = bList.get(j);
                if (bNumber % primeNumbers.get(i) == 0) {
                    aList.add(bList.get(j));
                } else {
                    auxList.add(bList.get(j));
                }
            }

            // Update bList and reverse aList
            bList.clear();
            bList.addAll(auxList);
            Collections.reverse(aList);
            answer.addAll(aList);
            aList.clear();
            auxList.clear();
        }

        // Reverse remaining bList and add to final answer
        Collections.reverse(bList);
        answer.addAll(bList);
        return answer;
    }

    /**
     * This method generates a list of prime numbers up to the number n.
     * @param n The upper limit for generating primes
     * @return List of prime numbers
     */
    public static List<Integer> primeNumbersTill(int n) {
        return IntStream.rangeClosed(2, n)
                .filter(Waiter::isPrime).boxed()
                .collect(Collectors.toList());
    }

    /**
     * This method checks if a given number is prime.
     * @param number The number to check
     * @return True if the number is prime, else false
     */
    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) (Math.sqrt(number)))
                .allMatch(n -> number % n != 0);
    }
}
