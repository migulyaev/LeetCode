/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        val queueP = ArrayDeque<Node>()
        val queueQ = ArrayDeque<Node>()
        if (p == null && q != null || p != null && q == null) {
            return false
        }
        if (p == null && q == null) {
            return true
        }
        queueP.addLast(Node(true, p!!))
        queueQ.addLast(Node(true, q!!))
        
        while (queueP.isNotEmpty() || queueQ.isNotEmpty()) {
            if (queueP.size != queueQ.size) {
                return false
            }
            val size = queueP.size
            for (i in 0 until size) {
                val pValue = queueP.removeFirst()
                val qValue = queueQ.removeFirst()
                if (pValue.isFromLeft != qValue.isFromLeft || pValue.node.`val` != qValue.node.`val`) {
                    return false
                }
                if (pValue.node.left != null) {
                    queueP.addLast(Node(true, pValue.node.left!!))
                }
                if (pValue.node.right != null) {
                    queueP.addLast(Node(false, pValue.node.right!!))
                }
                if (qValue.node.left != null) {
                    queueQ.addLast(Node(true, qValue.node.left!!))
                }
                if (qValue.node.right != null) {
                    queueQ.addLast(Node(false, qValue.node.right!!))
                }
            }
        }
        
        return true
    }
    
    data class Node(
        val isFromLeft: Boolean,
        val node: TreeNode,
    )
}