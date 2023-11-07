class Solution {
    fun solution(x: Int, n: Int): LongArray {
        var answer = LongArray(n)

        var xLong = x.toLong()

        for(idx in 0 until n) {
            answer[idx] = xLong * (idx + 1)
        }



        return answer
    }
}