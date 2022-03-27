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
    private var count = 0

    fun countNodes(root: TreeNode?): Int {
        count = 0
        countNodesRecursive(root)
        return count
    }
    
    private fun countNodesRecursive(node: TreeNode?) {
        if (node == null) {
            return
        }
        count++
        countNodesRecursive(node.left)
        countNodesRecursive(node.right)
    }
}