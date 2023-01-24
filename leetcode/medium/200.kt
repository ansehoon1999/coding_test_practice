class Solution {
    val dr = listOf(1, -1, 0, 0)
    val dc = listOf(0, 0, 1, -1)

    fun numIslands(grid: Array<CharArray>) : Int {
        val m = grid.size
        val n = grid[0].size
        val visited = MutableList<MutableList<Boolean>>(m) { MutableList<Boolean>(n) { false }}

        fun dfs (r : Int, c : Int, visited : MutableList<MutableList<Boolean>>) {

            val deque = ArrayDeque<Pair<Int, Int>>()
            deque.add(Pair(r, c))
            visited[r][c] = true

            while (deque.isNotEmpty()) {
                // println(deque)
                val node = deque.pop()

                for (i in 0 until 4) {
                    val row = node.first + dr[i]
                    val col = node.second + dc[i]

                    if (row < 0 || row >= m || col < 0 || col >= n) continue

                    if (grid[row][col].toInt() == 49 && !visited[row][col]) {
                        deque.add(Pair(row, col))
                        visited[row][col] = true
                    }
                }
            }
        }

        var count = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j].toInt() == 49 && !visited[i][j]) {
                    dfs(i, j, visited)
                    count ++
                    println()
                }
            }
        }
        
        return count


    }
}