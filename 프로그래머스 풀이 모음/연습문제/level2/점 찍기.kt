class Solution {
    fun solution(k: Int, d: Int): Long {
        var answer: Long = 0

        for(x in 0 until (d+1) step(k)) {
            val yCnt = countPoint(x, k, d)
            answer += (yCnt + 1)
        }

        return answer
    }

    fun countPoint(x: Int, k: Int, d: Int): Int {
        val y = Math.sqrt(Math.pow(d.toDouble(), 2.toDouble()) - Math.pow(x.toDouble(), 2.toDouble()))
        return (y / k).toInt()
    }
}