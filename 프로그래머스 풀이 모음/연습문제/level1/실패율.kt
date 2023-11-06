class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = intArrayOf()

        val stageArray = IntArray(N+2)
        var stageTotal = stages.size

        stages.forEach { stage ->
            stageArray[stage] = stageArray[stage] + 1
        }


        var failRateList = mutableListOf<Pair<Int, Float>>()

        for(idx in 1 .. N) {

            if(stageTotal.toFloat() == 0.0f) {
                failRateList.add(Pair(idx, 0.0f))
                continue
            }

            failRateList.add(Pair(idx, (stageArray[idx].toFloat() / stageTotal.toFloat())))

            stageTotal -= stageArray[idx]
        }

        failRateList.sortByDescending { it.second }


        var failRateArray = IntArray(N)
        for(idx in 0 until N) {
            failRateArray[idx] = failRateList[idx].first
        }


        return failRateArray
    }
}