class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0

        val maxNum = citations.maxOf { it }
        val minNum = citations.minOf { it }

        for(num in citations.size downTo 0) {

            var hCount = 0

            citations.forEach {

                if(it >= num) {
                    hCount ++
                }
            }

            if(hCount >= num) {
                answer = num
                break
            }
        }

        return answer
    }
}