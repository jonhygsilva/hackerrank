package com.coding.challenge.hackerrank

// Problema 2: Encontrar a distância mínima entre dois elementos em um array
class MinDistanceFinder {
    /*
        Problem: Given an array of integers, find the minimum distance between two elements num1 and num2.

        The distance is the difference between the indices of the two occurrences of num1 and num2 in the array.
        The goal is to return the minimum distance between them. If either of the numbers is not found in the array,
        return -1.

        Input:
        - An array of integers.
        - Two integers num1 and num2.

        Output:
        - An integer representing the minimum distance between num1 and num2. If either of the numbers is not found,
          return -1.

        Example:
        For the array [1, 2, 2, 2, 5, 2] and the numbers 1 and 2, the minimum distance is 1,
        because the closest occurrences of 1 (at index 0) and 2 (at index 1) are only 1 index apart.
    */

    fun findMinDistance(arr: Array<Int>, num1: Int, num2: Int): Int {
        var minDist = Int.MAX_VALUE
        var lastPosNum1 = -1
        var lastPosNum2 = -1

        for (i in arr.indices) {
            if (arr[i] == num1) {
                lastPosNum1 = i
            } else if (arr[i] == num2) {
                lastPosNum2 = i
            }

            // If both numbers have been found, calculate the distance
            if (lastPosNum1 != -1 && lastPosNum2 != -1) {
                minDist = Math.min(minDist, Math.abs(lastPosNum1 - lastPosNum2))
            }
        }

        // If one of the numbers is not found, return -1
        return if (minDist == Int.MAX_VALUE) -1 else minDist
    }
}


fun main(args: Array<String>) {
    val arr = arrayOf(1, 2, 2, 2, 5, 2)
    val num1 = 1
    val num2 = 2
    val minDist = MinDistanceFinder().findMinDistance(arr, num1, num2)

    println("The minimum distance between $num1 and $num2 is: $minDist") // Expected output: 1
}