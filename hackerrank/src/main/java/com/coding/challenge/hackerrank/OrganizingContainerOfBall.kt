package com.coding.challenge.hackerrank

class OrganizingContainerOfBall {
    /*
 * Complete the 'organizingContainers' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts 2D_INTEGER_ARRAY container as parameter.
 */

    fun organizingContainers(container: Array<Array<Int>>): String {
        val n = container.size

        // Calculate total balls in each container and total balls of each type
        val containerSums = IntArray(n)
        val typeSums = IntArray(n)

        for (i in 0 until n) {
            for (j in 0 until n) {
                containerSums[i] += container[i][j]
                typeSums[j] += container[i][j]
            }
        }

        // Sort the totals to compare
        containerSums.sort()
        typeSums.sort()

        return if (containerSums.contentEquals(typeSums)) "Possible" else "Impossible"
    }
}

fun main(args: Array<String>) {
    val container = arrayOf(
        arrayOf(1, 1, 1),
        arrayOf(2, 1, 1),
        arrayOf(3, 3, 3)
    )

    val result = OrganizingContainerOfBall().organizingContainers(container)

    println(result)
}