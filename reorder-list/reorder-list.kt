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
    fun reorderList(head: ListNode?): Unit {
        var node = head
        val l = arrayListOf<ListNode>()
        while (node != null) {
            l.add(node)
            node = node?.next
        }
        node = head
        for (i in 0 until l.size) {
            if (i % 2 == 0) {
                node?.next = l[l.size - 1 - (i/2)]
            } else {
                node?.next = l[(i+1)/2]
            }
            node = node?.next
        }
        node?.next = null
    }
}