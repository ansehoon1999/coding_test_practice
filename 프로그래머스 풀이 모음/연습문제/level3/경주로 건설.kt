import java.util.*

class Solution {

    val dr = listOf(0, 1, 0, -1)
    val dc = listOf(1, 0, -1, 0)

    fun solution(board: Array<IntArray>): Int {


        return bfs(board.size, board)
    }

    fun bfs(n: Int, board: Array<IntArray>): Int {

        val deque = ArrayDeque<Car>()

        val visited = MutableList<MutableList<MutableList<Int>>>(n) {
            MutableList<MutableList<Int>>(n) {
                MutableList<Int>(4) { Integer.MAX_VALUE }
            }
        }

        deque.add(Car(0, 0, 0, -1))

        while(deque.isNotEmpty()) {
            val (r, c, cost, direct) = deque.poll()

            for(i in 0 .. 3) {
                val tempR = r + dr[i]
                val tempC = c + dc[i]

                if(tempR < 0 || tempR >= n || tempC < 0 || tempC >= n) continue

                if(board[tempR][tempC] == 1) continue

                val next = if(direct == i || direct == -1) {
                    cost + 100
                } else cost + 600

                if(visited[tempR][tempC][i] > next) {
                    visited[tempR][tempC][i] = next
                    deque.add(Car(tempR, tempC, next, i))
                }
            }
        }


        var answer = Integer.MAX_VALUE

        visited[n-1][n-1].forEach { v ->
            answer = minOf(answer, v)
        }

        return answer
    }
}

data class Car(
    val r: Int,
    val c: Int,
    val cost: Int,
    val direct: Int
)