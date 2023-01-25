class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        var intervals = intervals
        // 1. 먼저 sort하기

        /*
            case1. before[1] < after[0] -> 
                before[0] == after[0] -> 뒤에꺼 저장
                else 앞에꺼 저장하고 뒤로 미루기

            case2. after[0] <= before[1] -> [before[0], after[1]]
        
         */ 
        
        val result = mutableListOf<IntArray>()
        intervals.sortBy {it[1]}
        intervals.sortBy {it[0]}

        for (i in 1 until intervals.size) {
            // println(intervals.map { it.toList() })
            val before = intervals[i-1]
            val after = intervals[i]

            if (before[0] == after[0]) {
                
            } else {
                if (before[1] < after[0]) {
                    result.add(before)
                } else if (before[1] == after[0]) {
                    intervals[i][0] = intervals[i-1][0]
                } else if (before[1] > after[0]) {
                    intervals[i][0] = intervals[i-1][0]
                    intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1])
                }
            }
        }

        // println(intervals.map { it.toList() })

        result.add (intervals.last())
        // println()
        // result.forEach {
        //     println(it.toList())
        // }



        return result.toTypedArray()
    }


}