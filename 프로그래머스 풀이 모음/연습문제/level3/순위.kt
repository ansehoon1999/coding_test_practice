class Solution {


    lateinit var board: MutableList<MutableList<Boolean>>

    fun solution(n: Int, results: Array<IntArray>): Int {
        var answer = 0

        board = MutableList<MutableList<Boolean>>(n + 1) {
            MutableList<Boolean>(n + 1) { false }
        }

        results.forEach { (a, b) ->
            board[a][b] = true
        }


        board.forEach {
            println(it)
        }

        for(k in 1 .. n) {
            for(i in 1 .. n) {
                for(j in 1 .. n) {
                    if(board[i][k] && board[k][j]) {
                        board[i][j] = true
                    }
                }
            }
        }

        for(i in 1 .. n) {
            var flag = true
            for(j in 1 .. n) {
                if(i != j && !(board[i][j] xor board[j][i])) flag = false
            }

            if(flag) answer ++
        }


        return answer
    }

}