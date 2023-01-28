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
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val list = mutableListOf<ListNode>()

        var head = head
        while (head != null) {
            list.add(ListNode(head?.`val`))
            head = head?.next
        }

        list.forEach {
            println(it.`val`)
        }

        if (list.size == 1 && n == 1) return null
        else { 
            var root : ListNode? = null
            if (list.size - n == 0) {
                root = ListNode(list[1].`val`)
                var curr = root
                for (i in 2 until list.size) {
                    curr?.next = list[i]
                    curr = curr?.next 
                } 
            } else {
                root = ListNode(list[0].`val`)
                var curr = root
                for (i in 1 until list.size) {
                    if (list.size - n != i) {
                        curr?.next = list[i]
                        curr = curr?.next 
                    }    
                }

            }
            
            
            return root

        }
    }
}