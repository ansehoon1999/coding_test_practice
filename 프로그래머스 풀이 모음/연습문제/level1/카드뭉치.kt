import java.util.*

class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var answer: String = ""

        val cards1Queue: Deque<String> = ArrayDeque()
        cards1.forEach { card ->
            cards1Queue.add(card)
        }

        val cards2Queue: Deque<String> = ArrayDeque()
        cards2.forEach { card ->
            cards2Queue.add(card)
        }

        for(i in 0 until goal.size) {
            val target = goal[i]


            val goal1Front = if(cards1Queue.isNotEmpty()) cards1Queue.first() else ""
            val goal2Front = if(cards2Queue.isNotEmpty()) cards2Queue.first() else ""

            if(goal1Front == target) {
                cards1Queue.removeFirst()
                continue
            }

            if(goal2Front == target) {
                cards2Queue.removeFirst()
                continue
            }

            if(goal1Front != target && goal2Front != target) {
                return "No"
            }
        }

        // println(cards1Queue)
        // println(cards2Queue)

        return "Yes"
    }
}