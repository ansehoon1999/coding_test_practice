class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        var answer: Int = 0

        data.sortByDescending { it[0] }
        data.sortBy { it[col - 1] }


        for(i in row_begin .. row_end) {
            var cnt = 0

            for(dataIdx in 0 until data[0].size) {
                cnt += (data[i-1][dataIdx] % i)
            }

            answer = answer.xor(cnt)
        }


        return answer
    }
}