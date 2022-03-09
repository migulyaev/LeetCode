/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution {
    
    private val copiedNodes = hashMapOf<Node, Node>()

    fun copyRandomList(node: Node?): Node? {
        if (node == null) {
            return null
        }
        
        if (copiedNodes.containsKey(node)) {
            return copiedNodes[node]
        }
        
        val copyNode = Node(node.`val`)
        copiedNodes[node] = copyNode

        copyNode.next = copyRandomList(node?.next)
        copyNode.random = copyRandomList(node?.random)
        return copyNode
    }
    
}