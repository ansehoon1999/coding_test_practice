import java.util.*

class Solution {

    val deque = ArrayDeque<Pair<Int, Int>>()

    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0

        priorities.forEachIndexed { idx, priority ->
            deque.add(Pair(idx, priority))
        }

        println(deque)
        var cnt = 0

        while(deque.isNotEmpty()) {

            val cur = deque.poll()

            val maxPair = deque.maxByOrNull { it.second }

            if(maxPair == null) {
                return cnt + 1
            }

            if(cur.second < maxPair.second) {
                deque.add(cur)
            } else {

                cnt ++

                if(cur.first == location) {
                    break
                }
            }

        }


        return cnt
    }
}