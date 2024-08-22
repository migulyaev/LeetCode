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
    
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        revertChildren(root)
        return root
    }
    
    private fun revertChildren(root: TreeNode?) {
        root ?: return
        val temp = root.left
        root.left = root.right
        root.right = temp
        revertChildren(root.left)
        revertChildren(root.right)
    }
    
}