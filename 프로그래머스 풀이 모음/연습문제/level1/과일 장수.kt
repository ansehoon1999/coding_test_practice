class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0

        score.sortDescending()

        val chunked = score.toList().chunked(m)

        for(i in 0 until chunked.size) {

            if(chunked[i].size != m) break

            val minNum = chunked[i].minOrNull() ?: 0
            answer = answer + minNum * m
        }

        return answer
    }
}