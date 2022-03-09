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
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var result: ListNode? = null
        var node1 = list1
        var node2 = list2
        var lastNode: ListNode? = null
        while (node1 != null || node2 != null) {
            val value1 = node1?.`val` ?: 101
            val value2 = node2?.`val` ?: 101
            val min = Math.min(value1, value2)
            if (result == null) {
                result = ListNode(min)
                lastNode = result
            } else {
                lastNode?.next = ListNode(min)
                lastNode = lastNode?.next
            }
            if (min == value1) {
                node1 = node1?.next
            } else {
                node2 = node2?.next
            }
        }
        return result
    }
}