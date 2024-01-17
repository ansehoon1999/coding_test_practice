class Solution {
    fun solution(stones: IntArray, k: Int): Int {
        var answer = 0

        var min = 1
        var max = 200000000

        while(min <= max) {

            val mid = (min + max) / 2

            if(canCross(stones, mid, k)) {
                min = mid + 1
                answer = maxOf(answer, mid)
            } else {
                max = mid - 1

            }
        }

        return answer
    }

    fun canCross(stones: IntArray, mid: Int, k: Int): Boolean {

        var skip = 0

        stones.forEach { stone ->

            if(stone - mid < 0) skip ++

            else skip = 0

            if(skip == k) return false
        }

        return true
    }


}