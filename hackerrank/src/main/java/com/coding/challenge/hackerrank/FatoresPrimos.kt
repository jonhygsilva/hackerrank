import java.lang.Math.sqrt
import java.util.*
import kotlin.collections.ArrayList

class PrimeFactors {

    /**
     * Problem: Find numbers with exactly N prime factors.
     *
     * Given a range of numbers from [a, b], the goal is to find all the numbers within
     * this range that have exactly N prime factors. The prime factors of a number are
     * the prime numbers that divide the number.
     *
     * Example:
     * If we have numbers between 1 and 10, we want to find the numbers that have exactly
     * 2 prime factors.
     *
     * Input:
     * - Three integers: a, b, and n.
     * - a and b define the range of numbers to be checked.
     * - n is the number of prime factors desired.
     *
     * Output:
     * - A list of numbers within the range [a, b] that have exactly n prime factors.
     */

    /**
     * Function to calculate the prime factors of a number.
     *
     * @param number The number for which the prime factors are to be calculated.
     * @return A list containing all the prime factors of the number.
     */
    fun calculatePrimeFactors(number: Int): ArrayList<Int> {
        val factors: ArrayList<Int> = arrayListOf()
        var n = number

        // Dividing the number by 2 while it is divisible by 2
        while (n % 2 == 0) {
            factors.add(2)
            n /= 2
        }

        // Checking divisibility for odd numbers up to the square root of the number
        val squareRoot = sqrt(n.toDouble()).toInt()
        for (i in 3..squareRoot step 2) {
            while (n % i == 0) {
                factors.add(i)
                n /= i
            }
        }

        // If the remaining number is greater than 2, it is prime
        if (n > 2) {
            factors.add(n)
        }

        return factors
    }

    /**
     * Function to find all the numbers within the range [a, b] that have exactly n prime factors.
     *
     * @param start The starting value of the range.
     * @param end The ending value of the range.
     * @param n The number of prime factors desired.
     */
    fun findNumbersWithNPrimeFactors(start: Int, end: Int, n: Int) {
        // Checking if the input is valid
        if (start > end) {
            println("The value of 'start' cannot be greater than 'end'.")
            return
        }

        var found = false

        // Iterating from start to end
        for (i in start..end) {
            val factors = calculatePrimeFactors(i)
            if (factors.size == n) {
                println(i)
                found = true
            }
        }

        // If no number with n prime factors was found
        if (!found) {
            println("No number in the range has exactly $n prime factors.")
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    // Reading values for start, end, and n
    println("Enter the starting value (start of the range):")
    val start = scanner.nextInt()
    println("Enter the ending value (end of the range):")
    val end = scanner.nextInt()
    println("Enter the number of prime factors n:")
    val n = scanner.nextInt()

    // Calling the function to print numbers in the range with exactly n prime factors
    PrimeFactors().findNumbersWithNPrimeFactors(start, end, n)
}
