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
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {

        val pq = PriorityQueue<ListNode>(compareBy( { it.`val`}))

        for (i in 0 until lists.size) {
            var node = lists[i]
            while (node != null) {
                pq.add(ListNode(node?.`val`))
                node = node?.next
            }
        }

        if (pq.size == 0) {
            return null
        } else {
            var root = ListNode(pq.poll().`val`)
            var curr = root
            for (i in 0 until pq.size) {
                curr.next = pq.poll()
                curr = curr.next

            }
            return root

        }
    }
}