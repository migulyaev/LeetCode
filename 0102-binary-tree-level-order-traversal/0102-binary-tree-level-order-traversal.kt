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
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val level = calculateLevel(root, 1)
        val ans = arrayListOf<List<Int>>()
        for (i in 1 until level) {
            ans.add(arrayListOf<Int>())
        }
        addAllNodes(ans, root, 0)
        return ans
    }
    
    private fun addAllNodes(ans: List<List<Int>>, node: TreeNode?, currentLevel: Int) {
        if (node == null) {
            return
        }
        (ans[currentLevel] as ArrayList<Int>).add(node.`val`)
        addAllNodes(ans, node.left, currentLevel + 1)
        addAllNodes(ans, node.right, currentLevel + 1)
    }
    
    private fun calculateLevel(node: TreeNode?, currentLevel: Int): Int {
        if (node == null) {
            return currentLevel
        }
        val left = calculateLevel(node.left, currentLevel + 1)
        val right = calculateLevel(node.right, currentLevel + 1)
        return max(left, right)
    }
}