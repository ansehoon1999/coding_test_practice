import java.util.*

class Solution {

    lateinit var visited: MutableList<MutableList<Boolean>>

    val dr = listOf(1, -1, 0, 0)
    val dc = listOf(0, 0, 1, -1)

    fun solution(board: Array<String>): Int {
        var answer: Int = 0

        var startR = 0
        var startC = 0

        visited = MutableList<MutableList<Boolean>>(board.size) {
            MutableList<Boolean>(board[0].length) { false }
        }

        for(i in 0 until board.size) {
            val boardList = board[i].toList()
            for(j in 0 until boardList.size) {
                if(boardList[j] == 'D') {
                    visited[i][j] = true
                }

                if(boardList[j] == 'R') {
                    startR = i
                    startC = j
                }
            }
        }

        val deque = ArrayDeque<Triple<Int, Int, Int>>()
        deque.add(Triple(startR, startC, 0))

        while(deque.isNotEmpty()) {
            val cur = deque.removeFirst()
            val curR = cur.first
            val curC = cur.second
            val curCnt = cur.third

            if(board[curR][curC] == 'G') {

                return curCnt
            }

            visited[curR][curC] = true

            for(i in 0 until 4) {
                var newR = curR + dr[i]
                var newC = curC + dc[i]

                if(newR < 0 || newR >= board.size || newC < 0 || newC >= board[0].length) continue

                while((newR in 0 .. board.size - 1) && (newC in 0 .. board[0].length - 1) && board[newR][newC] != 'D') {
                    // println("new ${newR}, ${newC} ${visited[newR][newC]}")
                    newR = newR + dr[i]
                    newC = newC + dc[i]

                }

                newR = newR - dr[i]
                newC = newC - dc[i]


                if(!visited[newR][newC]) {
                    deque.add(Triple(newR, newC, curCnt + 1))
                }


            }

        }



        return -1
    }
}