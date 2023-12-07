class Solution {


    fun solution(arr: Array<IntArray>): IntArray {
        var answer: IntArray = intArrayOf(0, 0)

        quad(answer, arr, 0, 0, arr.size)

        return answer
    }

    fun quad(answer: IntArray, arr: Array<IntArray>, row: Int, col: Int, len: Int) {

        if(len < 1) return

        var countOne = 0
        var countZero = 0

        for(i in row until row+len) {
            for(j in col until col+len) {
                if(arr[i][j] == 1) countOne ++
                else countZero ++
            }
        }

        if(countZero == len * len) {
            answer[0] = answer[0] + 1
            return
        } else if(countOne == len * len) {
            answer[1] = answer[1] + 1
            return
        }

        quad(answer, arr, row, col, len/2)
        quad(answer, arr, row + len/2, col, len/2)
        quad(answer, arr, row, col + len/2, len/2)
        quad(answer, arr, row + len/2, col + len/2, len/2)
    }
}