// Problema 1: Cálculo da profundidade máxima de uma árvore binária
data class Node(var data: Int) {
    var left: Node? = null
    var right: Node? = null
}

class Btree {
    /*
        Problem: Given a binary tree, find its maximum depth.
        
        The depth of a binary tree is the number of nodes along the longest path from the root node
        down to the farthest leaf node. A leaf node is a node with no children.
        
        Input:
        - A binary tree root node.
        
        Output:
        - The maximum depth of the tree.
        
        Example:
        For the binary tree:
        
              1
             / \
            2   3
           / \
          4   5
          
        The maximum depth is 3, because the longest path is from root 1 -> 2 -> 4.
    */

    fun maxDepth(node: Node?): Int {
        if (node == null) return 0

        // Compute the depth of left and right subtrees
        val lDepth = maxDepth(node.left)
        val rDepth = maxDepth(node.right)

        // Use the larger one
        return Math.max(lDepth, rDepth) + 1
    }
}

fun main(args: Array<String>) {
    val root = Node(1)
    root.left = Node(2)
    root.right = Node(3)
    root.left!!.left = Node(4)
    root.left!!.right = Node(5)

    println("Max Depth of Tree: ${Btree().maxDepth(root)}") // Expected output: 3
}

