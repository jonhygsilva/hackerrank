package com.coding.challenge.hackerrank

import java.lang.Math.sqrt
import java.util.*
import kotlin.collections.ArrayList

class FatoresPrimos {
    fun primeFactors(number: Int): ArrayList<Int> {

        // Array that contains all the prime factors of given number.
        val arr: ArrayList<Int> = arrayListOf()


        var n = number

        while (n % 2 == 0) {
            arr.add(2)
            n /= 2
        }

        val squareRoot = sqrt(n.toDouble()).toInt()

        for (i in 3..squareRoot step 2) {
            while (n % i == 0) {
                arr.add(i)
                n /= i
            }
        }

        if (n > 2) {
            arr.add(n)
        }

        return arr
    }

    fun a(a: Int, b: Int, n: Int) {
        for (i in a .. b) {
            val factors = primeFactors(i)
            if (factors.size == n) {
                println(i)
            }
        }
    }
}


fun main(args: Array<String>) {

    val scanner = Scanner(System.`in`)

    val a = scanner.nextInt()
    val b = scanner.nextInt()
    val n = scanner.nextInt()

    FatoresPrimos().a(a, b, n)

//    println("Enter a number")
//    val n = scanner.nextInt()
//
//    if (n <= 1) {
//        println("No Prime Factor")
//    } else {
//        val factors = FatoresPrimos().primeFactors(n)
//        println("Prime Factors of $n")
//        for (number in factors) {
//            print("$number ")
//        }
//    }
}