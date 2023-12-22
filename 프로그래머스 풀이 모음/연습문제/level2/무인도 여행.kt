import java.util.*

class Solution {

    private lateinit var visited: MutableList<MutableList<Boolean>>

    private lateinit var newMaps: MutableList<MutableList<Int>>

    val dr = listOf(1, -1, 0, 0)
    val dc = listOf(0, 0, 1, -1)

    fun solution(maps: Array<String>): IntArray {
        var answer = mutableListOf<Int>()

        val rowLen = maps.size
        val colLen = maps[0].length

        visited = MutableList<MutableList<Boolean>>(rowLen) {
            MutableList<Boolean>(colLen) {
                false
            }
        }

        newMaps = MutableList<MutableList<Int>>(rowLen) {
            MutableList<Int>(colLen) {
                0
            }
        }

        for(row in 0 until maps.size) {
            val rowList = maps[row].toList()
            for(col in 0 until rowList.size) {
                if(rowList[col] != 'X') {
                    newMaps[row][col] = rowList[col].toString().toInt()
                }
            }
        }

        for(row in 0 until maps.size) {
            val rowList = maps[row].toList()
            for(col in 0 until rowList.size) {
                if(rowList[col] != 'X' && !visited[row][col]) {
                    val cnt = bfs(row, col)
                    answer.add(cnt)
                    // println(cnt)
                }
            }
        }

        answer.sort()

        if(answer.isEmpty()) return intArrayOf(-1)
        else return answer.toIntArray()
    }

    fun bfs(row: Int, col: Int): Int {
        var count = 0

        val deque = ArrayDeque<Pair<Int, Int>>()
        deque.add(Pair(row, col))
        visited[row][col] = true

        while(deque.isNotEmpty()) {
            // println("count: ${count},deque:  ${deque}")
            val cur = deque.poll()
            val curRow = cur.first
            val curCol = cur.second
            count += newMaps[curRow][curCol]

            for(idx in 0 until 4) {
                val nr = curRow + dr[idx]
                val nc = curCol + dc[idx]

                if(nr < 0 || nr >= newMaps.size || nc < 0 || nc >= newMaps[0].size) continue

                if(newMaps[nr][nc] == 0) continue

                if(!visited[nr][nc]) {
                    visited[nr][nc] = true
                    deque.add(Pair(nr, nc))
                }
            }
        }

        return count

    }
}