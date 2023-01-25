class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val row = matrix.size
        val col = matrix[0].size

        var row_top = 0
        var row_bottom = row - 1

        var col_left = 0
        var col_right = col - 1

        val result = mutableListOf<Int>()

        var point = Pair(0, 0)

        var count = 0
        var row_turn = "row_top" 
        var col_turn = "col_right"
        while (count < row * col) {
            

            if (row_top == point.first && row_turn.equals("row_top")) {
                 

                for (i in col_left .. col_right) {
                    point = Pair(point.first, i)
                    result.add(matrix[point.first][i])
                    count++
                }

                row_top += 1
                row_turn = "row_bottom"
                
                continue
            }

            if (col_right == point.second && col_turn.equals("col_right")) {
                for (i in row_top .. row_bottom) {
                    point = Pair(i, point.second)
                    result.add(matrix[i][point.second])
                    count++
                }

                col_right -= 1
                col_turn = "col_left"
                continue
            }

            if (row_bottom == point.first && row_turn.equals("row_bottom")) {
                for (i in col_right downTo col_left) {
                    point = Pair(point.first, i)
                    result.add(matrix[point.first][i])
                    count++
                }

                row_bottom -= 1
                row_turn = "row_top"

                continue
            }

            if (col_left == point.second && col_turn.equals("col_left")) {
                for (i in row_bottom downTo row_top) {
                    point = Pair(i, point.second)
                    result.add(matrix[i][point.second])
                    count++
                }

                col_left += 1
                col_turn = "col_right"
                continue
            }

            
        }

        println(result)
        return result.toList()
    }
}