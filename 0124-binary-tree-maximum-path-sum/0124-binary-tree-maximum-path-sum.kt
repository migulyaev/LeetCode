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
    var maxValue = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        root ?: return 0
        maxPath(root)
        return maxValue
    }
    
    private fun maxPath(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }
        val left = max(0, maxPath(node.left))
        val right = max(0, maxPath(node.right))
        maxValue = max(maxValue, left + right + node.`val`)
        return node.`val` + max(left, right)
    }
}