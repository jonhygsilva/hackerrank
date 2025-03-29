package com.coding.challenge.hackerrank

class ChanceToBeChampion {

    fun calculateRewardOptimized(initialReward: List<Int>): Set<Int> {
        val results = mutableSetOf<Int>()

        // Simulação baseada em índices rotativos para evitar permutações completas
        for (i in initialReward.indices) {
            val rotated = initialReward.drop(i) + initialReward.take(i)
            val calculated = rotated.mapIndexed { index, value -> value + (index + 1) }
            val maxValue = calculated.maxOrNull() ?: 0
            val originalValue = rotated[calculated.indexOf(maxValue)]
            results.add(originalValue)
        }

        return results
    }
}

fun main() {
    val array = listOf(8, 9, 10)

    val allWinners = ChanceToBeChampion().calculateRewardOptimized(array)

    println(allWinners.size)
}
