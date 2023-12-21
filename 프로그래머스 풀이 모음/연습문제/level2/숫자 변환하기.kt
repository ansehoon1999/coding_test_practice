import java.util.*

class Solution {

    lateinit var visited: BooleanArray

    fun solution(x: Int, y: Int, n: Int): Int {
        var answer: Int = 0

        visited = BooleanArray(1000001) { false }

        val deque = ArrayDeque<Pair<Int, Int>>()
        deque.add(Pair(x, 0))
        visited[x] = true

        while(deque.isNotEmpty()) {

            val cur = deque.poll()

            if(cur.first == y) return cur.second

            if((cur.first + n) <= y && !visited[cur.first + n]) {
                deque.add(Pair(cur.first + n, cur.second + 1))
                visited[cur.first + n] = true
            }

            if((cur.first * 2) <= y && !visited[cur.first * 2]) {
                deque.add(Pair(cur.first * 2, cur.second + 1))
                visited[cur.first * 2] = true
            }

            if((cur.first * 3) <= y && !visited[cur.first * 3]) {
                deque.add(Pair(cur.first * 3, cur.second + 1))
                visited[cur.first * 3] = true
            }
        }



        return -1
    }
}