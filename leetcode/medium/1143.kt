class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val matrix = MutableList<MutableList<Int>>(text1.length+1) { MutableList<Int>(text2.length+1) { 0 }}

        for (i in 1 .. text1.length ) {
            for ( j in 1 .. text2.length ) {
                if (text1[i-1] == text2[j-1]) matrix[i][j] = matrix[i-1][j-1] + 1
                else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1])
                }
            }
        } 

        
        return matrix[text1.length][text2.length]
    }
}