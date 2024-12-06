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
    private val leafs1 = arrayListOf<Int>()
    private val leafs2 = arrayListOf<Int>()
    
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        calculateLeafs(root1, -1, leafs1)
        calculateLeafs(root2, -1, leafs2)
        return leafs1 == leafs2
    }
    
    private fun calculateLeafs(node: TreeNode?, prevValue: Int, leafs: ArrayList<Int>): Boolean {
        if (node == null) {
            return true
        }
        val isLeaf1 = calculateLeafs(node.left, node.`val`, leafs)
        val isLeaf2 = calculateLeafs(node.right, node.`val`, leafs)
        if (isLeaf1 && isLeaf2) {
            leafs.add(node.`val`)
        }
        return false
    }

}