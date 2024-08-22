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
    fun maxDepth(root: TreeNode?): Int {
        val queue: ArrayDeque<TreeNode> = ArrayDeque<TreeNode>()
        var level = 0
        if (root == null) return 0
        queue.addFirst(root!!)
        while (queue.isNotEmpty()) {
            val size = queue.size
            for (i in 0 until size) {
                val node = queue.removeFirst()
                if (node.left != null) {
                    queue.addLast(node.left!!)
                }
                if (node.right != null) {
                    queue.addLast(node.right!!)
                }
            }
            level++
        }
        return level
    }

}