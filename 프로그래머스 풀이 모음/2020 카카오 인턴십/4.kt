import java.util.*
import kotlin.math.min

class Solution {
    private lateinit var isVisited : Array<Array<Array<Boolean>>> // isVisited[dir][y][x]
    private lateinit var map : Array<IntArray>
    private val dy = arrayOf(-1, 0, 1, 0)
    private val dx = arrayOf(0, 1, 0, -1)
    private var answer = Integer.MAX_VALUE
    private var R = 0
    private var C = 0
    fun solution(board: Array<IntArray>): Int {
        map = board // static영역에서 꺼내쓰기 위한 얕은복사
        R = map.size ; C = map[0].size

        isVisited = Array(4) {Array (R) {Array (C) {false}} }
        BFS(0, 0)
        return answer
    }

    fun BFS(x : Int, y : Int){
        val q : Queue<Dot> = LinkedList<Dot>()
        q.offer(Dot(x, y, -1, 0))
        /** initialize an Array **/
        isVisited[0][y][x] = true
        isVisited[1][y][x] = true
        isVisited[2][y][x] = true
        isVisited[3][y][x] = true

        while (!q.isEmpty()) {
            val cur = q.poll()

            if (cur.x == C - 1 && cur.y == R - 1) {
                answer = min(answer, cur.sum)
            }

            for (i in 0 until 4) {
                val nx = cur.x + dx[i]
                val ny = cur.y + dy[i]

                if (ny < 0 || ny >= R || nx < 0 || nx >= C || map[ny][nx] == 1) continue
                val new_cost = cur.sum + calc(cur.dir, i)
                // 가본적이 없거나, 가봤더라도 최소 비용을 갱신할 수 있는 길이어야 함
                if (new_cost > map[ny][nx] && isVisited[i][ny][nx]) continue
                q.offer(Dot(nx, ny, i, new_cost))
                isVisited[i][ny][nx] = true
                map[ny][nx] = new_cost
            }
        }
    }

    fun calc(cur_dir : Int, next_dir : Int) : Int = if (cur_dir == -1 || cur_dir == next_dir) 100 else 600
}
data class Dot(val x : Int, val y : Int, val dir : Int, val sum : Int)