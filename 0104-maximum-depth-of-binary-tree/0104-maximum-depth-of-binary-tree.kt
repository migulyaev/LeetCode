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
    var max = 0
    fun maxDepth(root: TreeNode?): Int {
        return helper(root, 1)
    }
    
    private fun helper(node: TreeNode?, depth: Int): Int {
        if (node == null) {
            return depth - 1
        }
        val left = helper(node.left, depth + 1)
        val right = helper(node.right, depth + 1)
        return max(left, right)
    }
}