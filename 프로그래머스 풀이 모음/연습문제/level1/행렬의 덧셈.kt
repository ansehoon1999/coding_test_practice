class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        var answer = arrayOf<IntArray>()

        val result = Array<IntArray>(arr1.size) { IntArray(arr1[0].size) }

        for(i in 0 until arr1.size) {
            for(j in 0 until arr1[i].size) {
                result[i][j] = arr1[i][j] + arr2[i][j]
            }
        }


        return result
    }
}