class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {

        val arr1ColSize = arr1.size
        val arr1RowSize = arr1[0].size

        val arr2ColSize = arr2.size
        val arr2RowSize = arr2[0].size

        var answer = Array<IntArray>(arr1ColSize) {
            IntArray(arr2RowSize) { 0 }
        }

        for(arr1Col in 0 until arr1ColSize) {
            for(arr2Row in 0 until arr2RowSize) {

                var total = 0

                for(k in 0 until arr1RowSize) {
                    total += (arr1[arr1Col][k] * arr2[k][arr2Row])
                }

                answer[arr1Col][arr2Row] = total
            }
        }

        return answer
    }
}