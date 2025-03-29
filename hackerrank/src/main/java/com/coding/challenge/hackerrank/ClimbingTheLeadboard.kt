package com.coding.challenge.hackerrank

class ClimbingTheLeadboard {

    /**
     * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem?isFullScreen=true
     */

    /*
    * Complete the 'climbingLeaderboard' function below.
    *
    * The function is expected to return an INTEGER_ARRAY.
    * The function accepts following parameters:
    *  1. INTEGER_ARRAY ranked
    *  2. INTEGER_ARRAY player
    */

    fun climbingLeaderboard(ranked: Array<Int>, player: Array<Int>): Array<Int> {
        val uniqueRanks = ranked.distinct() // Remove duplicates for dense ranking
        val result = Array(player.size) { 0 }

        var i = uniqueRanks.size - 1 // Start from the lowest rank

        for (j in player.indices) {
            val score = player[j]

            // Move up the leaderboard while the player's score is higher or equal
            while (i >= 0 && score >= uniqueRanks[i]) {
                i--
            }

            // Rank is 1-based, so add 2 to account for 0-based index and passing one rank
            result[j] = i + 2
        }

        return result
    }
}

fun main(args: Array<String>) {
    val ranked = arrayOf(100, 90, 90, 80, 75, 60)
    val player = arrayOf(50, 65, 77, 90, 102)

    val result = ClimbingTheLeadboard().climbingLeaderboard(ranked, player)

    println(result.joinToString("\n"))
}