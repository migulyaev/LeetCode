/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun deleteMiddle(head: ListNode?): ListNode? {
        var size = 0

        var node = head
        while (node != null) {
            size++
            node = node.next
        }
        
        if (size <= 1) {
            return null
        }
        
        val nodeToDelete = size / 2
        var i = 0
        node = head
        while (i < nodeToDelete - 1) {
            node = node?.next
            i++
        }
        
        node?.next = node?.next?.next
        
        return head
    }
}