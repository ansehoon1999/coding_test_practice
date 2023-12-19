class Solution {
    fun solution(targets: Array<IntArray>): Int {
        var answer: Int = 0

        targets.sortBy { it[1] }

        var cnt = 0
        var start = 0
        var end = 0

        for(idx in 0 until targets.size) {
            if(targets[idx][0] >= end) {
                cnt ++
                end = targets[idx][1]
            }

        }

        return cnt
    }
}