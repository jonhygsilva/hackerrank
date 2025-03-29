package com.coding.challenge.hackerrank

/**
 * Descricao do problema
 * temos um array com as notas de determinados clientes, a posicao no array identifica a posicao que o cliente ficou no campeonato
 * por exemplo, array [4,5,6] nessa ordem as pontuais seriam 4 + 3 = 7, 5 + 2 = 7, 6 + 1 = 7
 * o objetivo e retornar de acordo com as combinacoes de posicao, quantos clientes diferentes podem ser campeoes
 */
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
