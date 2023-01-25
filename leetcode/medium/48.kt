class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size

        val new_matrix = mutableListOf<IntArray>()
        for (col in 0 .. n-1) {
            val tmp = mutableListOf<Int>()
            for (row in n-1 downTo 0) {
                tmp.add(matrix[row][col])
            }
            new_matrix.add(tmp.toIntArray())
        }
    
    
        for (i in 0 until n) {
            for (j in 0 until n) {
                matrix[i][j] = new_matrix[i][j]
            }
        }
    }


}