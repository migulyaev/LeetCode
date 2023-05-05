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
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var head = head
        while (head?.`val` == `val` && head != null) {
            head = head?.next
        }
        var currentNode = head
        while (currentNode?.next != null) {
            if (currentNode?.next?.`val` == `val`) {
                currentNode?.next = currentNode?.next?.next
            } else {
                currentNode = currentNode?.next
            }
        }
        
        return head
    }
}