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
        if (list1 == null && list2 == null) return null
        else if (list1 == null) return list2
        else if (list2 == null) return list1

        var next1 = list1
        var next2 = list2
        var first = -1
        if (next1!!.`val` < next2!!.`val`) {
            first = next1?.`val`
            next1 = next1.next
        } else {
            first = next2?.`val`
            next2 = next2.next
        }

        var next3  = ListNode(first)
        var list3Start = next3

        while (next1 != null || next2 != null) {
            if(next1== null){
                next3.next = next2
                break
            }
            if(next2== null){
                next3.next = next1
                break
            }
            
            if (next1!!.`val` < next2!!.`val`) {
                next3.next = ListNode(next1?.`val`)
                next3 = next3.next
                next1 = next1.next 
            } else {                    
                next3.next = ListNode(next2?.`val`)
                next3 = next3.next
                next2 = next2.next
                
            }

        }

        return list3Start
    }
}