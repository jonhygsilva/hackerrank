package com.coding.challenge.hackerrank

import java.util.*

data class Node(var data: Int) {
    var left: Node? = null
    var right: Node? = null
}

object GfG {
    fun maxDepth(node: Node?): Int {
        if (node == null) return 0

        // compute the depth of left and right
        // subtrees
        val lDepth = maxDepth(node.left)
        val rDepth = maxDepth(node.right)

        // use the larger one
        return Math.max(lDepth, rDepth) + 1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        root.left!!.left = Node(4)
        root.left!!.right = Node(5)
        println(maxDepth(root))
    }
}


object Test {
    fun maxDepth(awe: Array<Int>, serie1: Int, serie2: Int): Int {
        var min = awe.size
        var serie1Index = 0
        var serie2Index = 0

        //for ((i,j) in (0..awe.size).zip(i .. awe.size))

        for (i in 1 .. awe.size) {
            for (j in awe) {
                println("J$j")
                if (j == serie1) {
                    serie1Index = i
                } else if (j == serie2) {
                    serie2Index  = i
                }


            }

        }
        return 0
    }

    @JvmStatic
    fun main(args: Array<String>) {
        maxDepth(arrayOf(1,2,2,2,5,2), 1, 2)
    }
}

class Btree {
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