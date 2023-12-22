class Solution {

    private lateinit var newMap: MutableList<MutableList<String>>
    private lateinit var visited: MutableList<MutableList<Boolean>>

    val dr = listOf(1, -1, 0, 0)
    val dc = listOf(0, 0, 1, -1)

    var rowLen = 0
    var colLen = 0

    var firstCount = Integer.MAX_VALUE
    var secondCount = Integer.MAX_VALUE

    fun solution(maps: Array<String>): Int {
        var answer: Int = 0

        rowLen = maps.size
        colLen = maps[0].length

        var s_pos = Pair(0, 0)
        var e_pos = Pair(0, 0)
        var l_pos = Pair(0, 0)

        newMap = MutableList<MutableList<String>>(rowLen) {
            MutableList<String>(colLen) {
                ""
            }
        }

        visited = MutableList<MutableList<Boolean>>(rowLen) {
            MutableList<Boolean>(colLen) {
                false
            }
        }

        for(row in 0 until rowLen) {
            val rowList = maps[row].toList()
            for(col in 0 until colLen) {
                if(rowList[col].toString() == "S") {
                    s_pos = Pair(row, col)
                }

                if(rowList[col].toString() == "E") {
                    e_pos = Pair(row, col)
                }

                if(rowList[col].toString() == "L") {
                    l_pos = Pair(row, col)
                }

                newMap[row][col] = rowList[col].toString()
            }
        }

        val deque1 = ArrayDeque<Triple<Int, Int, Int>>()
        deque1.add(Triple(s_pos.first, s_pos.second, 0))
        visited[s_pos.first][s_pos.second] = true

        while(deque1.isNotEmpty()) {
            val cur = deque1.removeFirst()

            if(cur.first == l_pos.first && cur.second == l_pos.second) {
                firstCount = minOf(firstCount, cur.third)
                break
            }

            for(i in 0 until 4) {
                val nr = cur.first + dr[i]
                val nc = cur.second + dc[i]

                if(nr < 0 || nr >= rowLen || nc < 0 || nc >= colLen) continue

                if(visited[nr][nc]) continue

                if(newMap[nr][nc] == "X") continue

                visited[nr][nc] = true
                deque1.add(Triple(nr, nc, cur.third + 1))
            }

        }

        if(firstCount == Integer.MAX_VALUE) return -1

        visited = MutableList<MutableList<Boolean>>(rowLen) {
            MutableList<Boolean>(colLen) {
                false
            }
        }

        val deque2 = ArrayDeque<Triple<Int, Int, Int>>()
        deque2.add(Triple(l_pos.first, l_pos.second, 0))
        visited[l_pos.first][l_pos.second] = true


        while(deque2.isNotEmpty()) {
            val cur = deque2.removeFirst()

            if(cur.first == e_pos.first && cur.second == e_pos.second) {
                secondCount = minOf(secondCount, cur.third)
                break
            }

            for(i in 0 until 4) {
                val nr = cur.first + dr[i]
                val nc = cur.second + dc[i]

                if(nr < 0 || nr >= rowLen || nc < 0 || nc >= colLen) continue

                if(visited[nr][nc]) continue

                if(newMap[nr][nc] == "X") continue

                visited[nr][nc] = true
                deque2.add(Triple(nr, nc, cur.third + 1))
            }

        }

        if(secondCount == Integer.MAX_VALUE) return -1

        return firstCount + secondCount
    }
}