class Solution {

    val hashMap = hashMapOf<Int, Int>(
            6 to 1,
            5 to 2,
            4 to 3,
            3 to 4,
            2 to 5,
            1 to 6,
            0 to 6
    )

    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {

        var matchedLottoCnt = 0
        var unknownLottoCnt = 0

        lottos.forEach { lotto ->
            if(lotto in win_nums) {
                matchedLottoCnt ++
            }

            if(lotto == 0) unknownLottoCnt ++
        }

        var maxCnt = matchedLottoCnt + unknownLottoCnt
        var minCnt = matchedLottoCnt


        return intArrayOf(hashMap[maxCnt]!!, hashMap[minCnt]!!)
    }
}