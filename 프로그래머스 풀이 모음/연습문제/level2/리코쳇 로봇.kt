import java.util.*

class Solution {

    private lateinit var visited: MutableList<MutableList<Int>>

    val dr = listOf(-1, 1, 0, 0)
    val dc = listOf(0, 0, -1, 1)

    fun solution(board: Array<String>): Int {
        var answer: Int = 0

        var startPoint = Pair(0, 0)
        var endPoint = Pair(0, 0)

        val rowLen = board.size
        val colLen = board[0].length

        visited = MutableList<MutableList<Int>>(rowLen) {
            MutableList<Int>(colLen) { 0 }
        }

        for(row in 0 until rowLen) {
            val rowList = board[row].toList()
            for(col in 0 until colLen) {
                if(rowList[col] == 'R') {
                    startPoint = Pair(row, col)
                } else if(rowList[col] == 'G') {
                    endPoint = Pair(row, col)
                }
            }
        }

        println(endPoint)

        visited[startPoint.first][startPoint.second] = 1
        val deque = ArrayDeque<Pair<Int, Int>>()
        deque.add(startPoint)

        var count = 0

        while(deque.isNotEmpty()) {
            val curPoint = deque.poll()

            if(curPoint.first == endPoint.first && curPoint.second == endPoint.second) {
                return visited[curPoint.first][curPoint.second] - 1
            }

            for(idx in 0 until 4) {

                var nr = curPoint.first
                var nc = curPoint.second

                while(true) {
                    nr = nr + dr[idx]
                    nc = nc + dc[idx]

                    if(nr in 0 .. rowLen-1 && nc in 0 .. colLen-1 && board[nr][nc] == 'D') {
                        nr = nr - dr[idx]
                        nc = nc - dc[idx]
                        break
                    }

                    if(nr < 0 || nr >= rowLen || nc < 0 || nc >= colLen) {
                        nr = nr - dr[idx]
                        nc = nc - dc[idx]
                        break
                    }
                }

                if(visited[nr][nc] == 0) {
                    visited[nr][nc] = visited[curPoint.first][curPoint.second] + 1
                    deque.add(Pair(nr, nc))
                }
            }
        }


        return -1
    }
}