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
        if (head != null && !(head.next == null || head.next!!.next == null)) {
            val list = mutableListOf<ListNode?>()

            var curr = head
            while (curr != null) {
                val tmp = ListNode(curr.`val`)
                list.add(tmp)
                curr = curr.next
            }

            // list.forEach {
            //     println(it!!.`val`)
            // }

            var left = 1
            var right = list.size - 1
            
            var root = list[0]
            var curr1 = root
            while ( left <= right) {
                if (left == right) {
                    curr1?.next = list[right]
                    curr1 = curr1?.next 
                } else {
                    // println("left ${left} right ${right}")
                    curr1?.next = list[right]
                    curr1 = curr1?.next
                    curr1?.next = list[left]
                    curr1 = curr1?.next

                }   
                left ++
                right --                 
            }

            head?.next = root?.next
        }
    }
}