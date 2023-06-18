class Solution {

    lateinit var personInTimeList: MutableList<Long>


    fun solution(n: Int, times: IntArray): Long {

        var min: Long = 0L
        var max: Long = times.maxOf { it }!!.toLong() * n

        while (min <= max) {
            val mid = (min + max) / 2

            var sum: Long = 0L
            times.forEach { sum += mid / it }

            if(sum >= n) max = mid - 1

            else min = mid + 1
        }

        return max + 1
    }
}