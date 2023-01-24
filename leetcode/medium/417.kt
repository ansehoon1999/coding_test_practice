class Solution {

    val dr = listOf(1, -1, 0, 0)
    val dc = listOf(0, 0, 1, -1)
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
            
            val result = mutableListOf<List<Int>>()
            val m = heights.size 
            val n = heights[0].size
            

            fun bfs (r : Int, c: Int, visited : MutableList<MutableList<Boolean>>) {
                
                // println("${r} ${c}")
                var pacific = false
                var atlantic = false

                val deque = ArrayDeque<Pair<Int, Int>>()
                deque.add(Pair(r, c))
                visited[r][c] = true
                while (deque.isNotEmpty()) {
                    // println(deque)

                    val node = deque.pop()

                    for (i in 0 until 4) {
                        val row = node.first + dr[i]
                        val col = node.second + dc[i]
                        // println("node ${node} row ${row} col ${col}")
                        if (row < 0 || col < 0 ) {
                            pacific = true
                            continue 
                        }

                        if (row >= m || col >= n) {
                            atlantic = true
                            continue
                        } 

                        if (heights[row][col] > heights[node.first][node.second]) continue

                        if(!visited[row][col]){
                            deque.add(Pair(row, col))
                            visited[row][col] = true
                        }

                    }    
                    if (pacific && atlantic) {
                        // println("${r} ${c} this!!")
                        result.add(listOf(r, c))
                        break
                    }
                }


            }
            for (i in 0 until m) {
                for (j in 0 until n) {
                    val visited = MutableList<MutableList<Boolean>>(m) { MutableList<Boolean>(n) { false } }
                    bfs(i, j, visited)
                }
            }

            // println(m)
            // println(n)

        return result
    }
}