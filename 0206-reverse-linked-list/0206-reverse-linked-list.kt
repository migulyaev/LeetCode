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
        head ?: return null
        var prev = head
        var next = head.next
        prev.next = null
        while (next != null) {
            val temp = next.next
            next.next = prev
            prev = next
            next = temp
        }
        return prev
    }
}

// prev = 1, next = 2
// temp = 3; 2.next = 1; prev = 2; next = 3
// temp = 4; 3.next = 2; prev = 3; next = 4
// temp = 5; 4.next = 3; prev = 4; next = 5
// temp = null; 5.next = 4; prev = 5; next = null
