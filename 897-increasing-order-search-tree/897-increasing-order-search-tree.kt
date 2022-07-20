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
    
    val h = PriorityQueue<Int>()

    fun increasingBST(root: TreeNode?): TreeNode? {
        h.clear()
        fillHeap(root)
        if (root == null) return null
        val root = TreeNode(h.poll())
        var current = root
        while (h.isNotEmpty()) {
            current.right = TreeNode(h.poll())
            current = current.right
        }
        return root
    }
    
    private fun fillHeap(root: TreeNode?) {
        if (root == null) return
        h.add(root.`val`)
        fillHeap(root.left)
        fillHeap(root.right)
    }
    
}