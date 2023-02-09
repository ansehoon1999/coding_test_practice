

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
    private fun addAdded(l: ListNode?, r: ListNode?): Int {
        return (l?.`val` ?: 0) + (r?.`val` ?: 0)
    }
    
    fun reverse (head : ListNode?) : ListNode? {
        
        var prev : ListNode? = null
        var curr : ListNode? = head
        var next : ListNode? = head
        
        while (curr != null) {
            next = curr?.next
            curr?.next = prev
            prev = curr
            curr = next
            
    
            
        }
        return prev
    }
    
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        
        var curLeft = reverse(l1)
        var curRight = reverse(l2)
        
        var cur : ListNode? = null
        var root : ListNode? = null
        
        var carry = 0
        
        while (curLeft != null || curRight != null || carry > 0) {
            var added = addAdded(curLeft, curRight) + carry
            carry = if(added > 9) 1 else 0
                        
            val node = ListNode(added % 10)
            if (root == null) {
                root = node
                cur = node
            } else {
                cur?.next = node
                cur = node
            }
            
            curLeft = curLeft?.next
            curRight = curRight?.next
            
        }
        
        
        
        
        return reverse(root)
    }
}