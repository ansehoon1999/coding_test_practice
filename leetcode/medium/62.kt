class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val matrix = MutableList<MutableList<Int>>(m) { MutableList<Int>(n) { 1 } }

        for (i in 1 until m) {
            for (j in 1 until n) {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1]
            }
        }
        
        return matrix[m-1][n-1]
    }
}