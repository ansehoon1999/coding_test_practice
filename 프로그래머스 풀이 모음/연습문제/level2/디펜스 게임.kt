import java.util.*

import java.util.*

class Solution {


    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var answer: Int = 0

        var N = n
        var K = k
        val pq = PriorityQueue<Int>(Collections.reverseOrder())

        for(e in enemy) {
            pq.add(e)

            N -= e

            while(N < 0 && K > 0) {
                N += pq.poll()
                K --
            }

            if(N < 0) break

            answer ++
        }

        return answer
    }

}