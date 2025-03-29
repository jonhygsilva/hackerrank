package com.coding.challenge.hackerrank

/**
 * Exemplo especifico quando a ordem importa, isso evita que a permutacao gere dados repetidos, e complexos
 * na rotacao geramos somente combinacoes unicas, por meio da rotacao dos valores no array
 *
 * Specific example when order matters, this prevents permutation from generating repeated and complex data
 * in rotation we generate only unique combinations, by rotating the values in the array
 *
 */
class PermutationWithRotation {
    fun generateRotations(list: List<Int>): List<List<Int>> {
        val rotations = mutableListOf<List<Int>>()
        for (i in list.indices) {
            val rotated = list.drop(i) + list.take(i)
            rotations.add(rotated)
        }
        return rotations
    }
}

fun main() {
    val list = listOf(8, 9, 10)
    val rotations = PermutationWithRotation().generateRotations(list)
    println("Rotations:")
    rotations.forEach { println(it) }
}
