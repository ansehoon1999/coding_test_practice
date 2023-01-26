class Solution {
    fun hasCycle(head: ListNode?): Boolean {
		// keep track of which nodes we already got to
        val already = HashSet<ListNode>()
        
        var current = head
        while (current != null) {
            if (!already.add(current)) return true
            current = current.next
        }

        return false
    }
}