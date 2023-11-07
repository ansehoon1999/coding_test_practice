class Solution {
    fun solution(n: Long): Long {
        var answer: Long = 0

        val sqrt = Math.sqrt(n.toDouble())
        if(sqrt == sqrt.toInt().toDouble()) {
            return (sqrt.toLong() + 1L) * (sqrt.toLong() + 1L)
        } else {
            return -1L
        }

    }
}