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
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
//         var result: ListNode? = null
//         var node1 = l1
//         var node2 = l2
//         var carry = 0
//         var lastNode: ListNode? = null
//         while (node1 != null || node2 != null) {
//             val value1 = node1?.`val` ?: 0
//             val value2 = node2?.`val` ?: 0
//             var sum = value1 + value2 + carry
//             if (sum >= 10) {
//                 carry = 1
//                 sum = sum % 10
//             } else {
//                 carry = 0
//             }
//             if (result == null) {
//                 result = ListNode(sum)
//                 lastNode = result
//             } else {
//                 lastNode?.next = ListNode(sum)
//                 lastNode = lastNode?.next
//             }
            
//             node1 = node1?.next
//             node2 = node2?.next
//         }
//         if (carry > 0) {
//             lastNode?.`val` = carry
//         }
        return getSum(l1, l2, 0)
    }
    
    private fun getSum(node1: ListNode?, node2: ListNode?, carry: Int): ListNode? {
        if (node1 == null && node2 == null) {
            if (carry > 0) {
                return ListNode(carry)
            } else {
                return null
            }
        }
        val sum = (node1?.`val` ?: 0) + (node2?.`val` ?: 0) + carry
        val newCarry = sum / 10
        val remainder = sum % 10
        val newNode = ListNode(remainder)
        newNode.next = getSum(node1?.next, node2?.next, newCarry)
        return newNode
    }
}