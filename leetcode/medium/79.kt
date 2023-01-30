class Solution {
    val ar = listOf(1, -1, 0, 0)
    val ac = listOf(0, 0, 1, -1)
    
    var state = false 
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val row = board.size
        val col = board[0].size

        val visited = MutableList<MutableList<Boolean>>(row) { MutableList<Boolean>(col) { false }}
        fun dfs(count : Int, r : Int, c : Int) {
            // visited.forEach {
            //     println(it)
            // }
            // println()

            if (count == word.length-1) {
                state = true
                return
            }

            

            for (i in 0 until 4) {
                val dr = r + ar[i]
                val dc = c + ac[i]

                if (dr < 0 || dr >= row || dc < 0 || dc >= col) continue
                if (visited[dr][dc]) continue
                
                if (word[count+1] == board[dr][dc]) {
                    visited[dr][dc] = true
                    dfs(count+1, dr, dc)
                    visited[dr][dc] = false
                }
            }

            
        }


        for (i in 0 until row) {
            for (j in 0 until col) {
                if (board[i][j] == word[0]) {
                    visited[i][j] = true
                    dfs(0, i, j)             
                    visited[i][j] = false
                }
            }
        }




        return state
    }
}
