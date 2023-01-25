class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        var intervals = intervals


        /*
            1. sort를 진행함
            2.
                2-1.  before[1] <= after[0] -> 그대로 진행
                2.2.  before[1] > after[0] -> 
                        before[0] 


         */

        intervals.sortBy { it[1] }
        intervals.sortBy { it[0] }


        var count = 0
        for (i in 1 until intervals.size) {
            val before = intervals[i-1]
            val after = intervals[i]

            if (before[0] == after[0]) {
                intervals[i][1] = intervals[i-1][1] 
                count ++
            } else {
                if (before[1] <= after[0]) {
                    intervals[i][0] = intervals[i-1][0] 
                } else if (before[1] > after[0]) {
                    if (before[1] > after[1]) {  -26 > -49
                        count ++
                    } else {
                        intervals[i] = intervals[i-1]
                        count ++
                    }
                    
                }
            }

            // println(intervals.map { it.toList() }.toList())
            // println(count)
        }

        return count
    }
}