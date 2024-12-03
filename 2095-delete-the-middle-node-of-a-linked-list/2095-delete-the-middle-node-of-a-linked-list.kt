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
        if (head?.next == null) {
            return null
        }
        var node = head
        var fastNode = head?.next?.next
        while (fastNode != null && fastNode.next != null) {
            node = node?.next
            fastNode = fastNode?.next?.next
        }
        
        node?.next = node?.next?.next
        
        return head
    }
}