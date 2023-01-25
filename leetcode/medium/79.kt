class Solution {
    val dr = listOf(1, -1, 0, 0)
    val dc = listOf(0, 0, 1, -1)
    
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val m = board.size
        val n = board[0].size
        
        var state = false

        fun dfs(count : Int, point : Pair<Int, Int>, visited : MutableList<MutableList<Boolean>>) {

            if (count == word.length) {
                state = true
                return
            } else {

                for (i in 0 until 4) {
                    val row = point.first + dr[i]
                    val col = point.second + dc[i]

                    if (row < 0 || row >= m || col < 0 || col >= n) continue

                    if (board[row][col] == word[count] && !visited[row][col]) {
                        visited[row][col] = true
                        dfs(count + 1, Pair(row, col), visited)
                        visited[row][col] = false
                    }
                }

            }
        }

        val first = mutableListOf<Pair<Int, Int>>()
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (word[0] == board[i][j]) {
                    first.add(Pair(i, j))
                }
            }
        }

        var visited = MutableList<MutableList<Boolean>>(m) { MutableList<Boolean>(n) { false} }
        first.forEach {
            visited[it.first][it.second] = true
            dfs(1, it, visited)
            visited[it.first][it.second] = false
        }

        println(first)
        return state

    }
}
