import kotlin.math.abs


class Solution {

    val dirsStr = listOf<String>("d", "l", "r", "u")
    val dirs = listOf<Pair<Int, Int>>(Pair(1, 0), Pair(0, -1), Pair(0, 1), Pair(-1, 0))

    lateinit var answer: StringBuilder
    var result = ""
    var endRow = 0
    var endCol = 0
    var mapRow = 0
    var mapCol = 0

    fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
        result = ""
        answer = StringBuilder()
        mapRow = n
        mapCol = m
        endRow = r
        endCol = c

        val distance = distance(x, y, endRow, endCol)
        if(distance > k || (k - distance) % 2 == 1) return "impossible"
        dfs(x, y, 0, k)

        if(result == "") {
            return  "impossible"
        } else {
            return result
        }
    }

    fun dfs(row: Int, col: Int, depth: Int, limit: Int) {
        if(result != "") return

        if(depth + distance(row, col, endRow, endCol) > limit) return

        if(limit == depth) {
            if(row == endRow && col == endCol) result = answer.toString()

            return
        }

        for(i in 0 until dirs.size) {
            val nRow = row + dirs[i].first
            val nCol = col + dirs[i].second

            if(nRow > 0 && nCol > 0 && nRow <= mapRow && nCol <= mapCol) {
                answer.append(dirsStr[i])
                dfs(nRow, nCol, depth+1, limit)
                answer.delete(depth, depth+1)
            }
        }
    }


    fun distance(x: Int, y: Int, r: Int, c: Int): Int {
        return abs(x-r) + abs(y-c)
    }
}