class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0

        val max_citation = citations.maxOf { it }

        val min_citation = citations.minOf { it }

        for(num_citation in max_citation downTo 0) {

            var h_count = 0
            citations.forEach {
                if (it >= num_citation) {
                    h_count ++
                }
            }

            if(h_count >= num_citation) {
                answer = num_citation
                break
            }

        }
        return answer
    }
}