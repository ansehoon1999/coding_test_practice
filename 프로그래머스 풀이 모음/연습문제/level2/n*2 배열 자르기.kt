class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer = mutableListOf<Int>()

        for(i in (left) .. (right)) {

            val row = (i / n) + 1
            val col = (i % n) + 1

            val maxNum = maxOf(row, col)

            answer.add(maxNum.toInt())

        }

        return answer.toIntArray()
    }
}