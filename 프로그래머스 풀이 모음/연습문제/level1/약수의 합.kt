class Solution {
    fun solution(n: Int): Int {
        var answer = 0

        for(num in 1 .. n) {
            if(isDivisor(num, n)) {
                answer += num
            }
        }

        return answer
    }

    fun isDivisor(num: Int, n: Int): Boolean {
        if(n % num == 0) {
            return true
        }

        return false
    }
}