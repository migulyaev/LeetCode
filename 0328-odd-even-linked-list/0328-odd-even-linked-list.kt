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
    fun oddEvenList(head: ListNode?): ListNode? {
        var node = head
        var lastOddNode = head
        var headEven: ListNode? = null
        while (node != null) {
            val even = node.next
            if (headEven == null) {
                headEven = even
            }
            node.next = even?.next
            even?.next = node?.next?.next
            lastOddNode = node
            node = node.next
        }
        lastOddNode?.next = headEven
        return head
    }
}