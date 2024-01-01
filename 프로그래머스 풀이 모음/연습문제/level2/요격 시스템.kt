class Solution {
    fun solution(targets: Array<IntArray>): Int {
        var answer: Int = 0

        targets.sortBy { it[0] }
        targets.sortBy { it[1] }

        // targets.forEach {
        //     println(it.toList())
        // }

        var befStart = 0
        var befEnd = 0

        targets.forEachIndexed { idx, target ->
            val curStart = target[0]
            val curEnd = target[1]

            if(idx == 0) {
                befStart = curStart
                befEnd = curEnd
                answer ++
            } else {
                if(befEnd <= curStart) {
                    befStart = curStart
                    befEnd = curEnd
                    answer ++
                }
            }
        }


        return answer
    }
}