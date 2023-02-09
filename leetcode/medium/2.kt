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

    fun add (l1: ListNode?, l2: ListNode?) : Int {
        return (l1?.`val` ?: 0) + (l2?.`val` ?: 0)
    }
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        
        var curLeft = l1
        var curRight = l2
        var curr : ListNode? = null
        var root : ListNode? = null
        
        var carry = 0
        
        while(curLeft != null || curRight != null || carry > 0) {
            
            val added = add(curLeft, curRight) + carry
            
            carry = if (added > 9) 1 else 0
            
            val node = ListNode(added % 10)
            
            if (root == null) {
                root = node
                curr = node
            } else {
                curr?.next = node
                curr = node
            }
            
            curLeft = curLeft?.next
            curRight = curRight?.next
            
        }
        
        return root
        
    }
}