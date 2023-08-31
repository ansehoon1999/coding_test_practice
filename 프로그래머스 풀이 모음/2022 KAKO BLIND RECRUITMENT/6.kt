class Solution {


    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        var answer = 0

        val tmp = Array<IntArray>(board.size+1) {
            IntArray(board[0].size + 1) {
                0
            }
        }


        skill.forEach {
            val type = it[0]

            val startRow = it[1]
            val startColumn = it[2]

            val endRow = it[3]
            val endColumn = it[4]

            val value = it[5]

            when(type) {
                1 -> {
                    tmp[startRow][startColumn] -= value
                    tmp[startRow][endColumn + 1] += value
                    tmp[endRow + 1][startColumn] += value
                    tmp[endRow + 1][endColumn + 1] -= value
                }
                2 -> {
                    tmp[startRow][startColumn] += value
                    tmp[startRow][endColumn + 1] -= value
                    tmp[endRow + 1][startColumn] -= value
                    tmp[endRow + 1][endColumn + 1] += value
                }
            }
        }

        for(row in 0 until tmp.size - 1) {
            for(col in 0 until tmp[0].size - 1) {
                tmp[row][col + 1] += tmp[row][col]
            }
        }

        for(col in 0 until tmp[0].size - 1) {
            for(row in 0 until tmp.size - 1) {
                tmp[row+1][col] += tmp[row][col]
            }
        }

        for(row in 0 until board.size ) {
            for(col in 0 until board[0].size) {
                board[row][col] += tmp[row][col]

                if(board[row][col] > 0) {
                    answer ++
                }
            }
        }


        return answer
    }



}