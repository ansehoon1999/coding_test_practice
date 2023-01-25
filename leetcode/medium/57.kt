class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        
        val afterIntervals = mutableListOf<IntArray>()

        var index = 0
        var intervalStart = newInterval.first()
        var intervalEnd = newInterval.last()

        while (index < intervals.size && intervals[index].last() < intervalStart) {
            afterIntervals.add(intervals[index])
            index ++
        }

        while (index < intervals.size && intervals[index].first() <= intervalEnd) {
            intervalStart = intervalStart.coerceAtMost(intervals[index].first())
            intervalEnd = intervalEnd.coerceAtLeast(intervals[index].last())
            index ++
            // println("${intervalStart} ${intervalEnd}")
        }

        afterIntervals.add(intArrayOf(intervalStart, intervalEnd))
        afterIntervals.addAll(intervals.copyOfRange(index, intervals.size))

        return afterIntervals.toTypedArray()
    }
}