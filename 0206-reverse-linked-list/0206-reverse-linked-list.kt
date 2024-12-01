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
    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        if (head.next == null) {
            return head
        }
        var prev = head
        var node = head.next
        head.next = null
        do {
            val tempNext = node?.next
            node?.next = prev
            prev = node
            node = tempNext
        } while (node != null)
        return prev
    }
}