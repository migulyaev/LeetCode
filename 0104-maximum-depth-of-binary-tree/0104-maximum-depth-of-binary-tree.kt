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
        return getMaxDepth(root, 1)
    }
    
    private fun getMaxDepth(current: TreeNode?, currentDepth: Int): Int {
        if (current == null) {
            return currentDepth - 1
        }
        val left = getMaxDepth(current.left, currentDepth + 1)
        val right = getMaxDepth(current.right, currentDepth + 1)
        return max(left, right)
    }
}