class Solution {

    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf(0, sequence.size)

        var start = 0
        var end = 0
        var sum = sequence[start]

        while(start < sequence.size && end < sequence.size && start <= end) {
            if(sum == k) {

                if(answer[1] - answer[0] > end - start) {
                    answer[0] = start
                    answer[1] = end
                }

                end ++
                if(end == sequence.size) continue
                sum += sequence[end]
            } else if(sum < k) {
                end ++
                if(end == sequence.size) continue
                sum += sequence[end]
            } else if(sum > k) {
                sum -= sequence[start]
                start++
            }
        }

        return answer
    }
}