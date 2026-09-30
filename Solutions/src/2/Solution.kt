package `2`

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
        val head = ListNode(0)
        var curr : ListNode? = head

        var p1 = l1
        var p2 = l2
        var carryOver = 0
        while (p1 != null || p2 != null || carryOver != 0) {
            val num1 = p1?.`val` ?: 0
            val num2 = p2?.`val` ?: 0
            val sum = (num1 + num2 + carryOver) % 10
            carryOver = (num1 + num2 + carryOver) / 10
            curr?.next = ListNode(sum)
            curr = curr?.next
            p1 = p1?.next
            p2 = p2?.next
        }

        return head.next
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}