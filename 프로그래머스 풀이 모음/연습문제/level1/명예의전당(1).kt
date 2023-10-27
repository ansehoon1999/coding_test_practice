class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        var result = mutableListOf<Int>()
        var answer = ArrayDeque<Int>()

        score.forEach { scoreValue ->

            answer.add(scoreValue)
            answer.sort()

            if(answer.size <= k) {
                result.add(answer.first())
            } else {
                result.add(answer[answer.size - k])
            }
        }

        return result.toIntArray()
    }
}