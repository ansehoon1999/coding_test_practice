class Solution {
    fun solution(w: Int, h: Int): Long {
        val result = gcd(w.toLong(), h.toLong())

        val newW = (w / result).toLong()
        val newH = (h / result).toLong()

        return (w.toLong() * h.toLong()) - (w + h - result).toLong()
    }

    fun gcd(a: Long, b: Long): Long {
        var maximum = maxOf(a, b)
        var minimum = minOf(a, b)

        if(minimum == 0L) {
            return maxOf(a, b)
        } else {
            return gcd(minimum, maximum % minimum)
        }
    }
}