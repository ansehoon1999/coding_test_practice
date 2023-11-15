class Solution {

    var count = 0L

    fun solution(n: Int): Long {
        var answer: Long = 0

        if(n == 1) return 1

        val list = LongArray(n + 1)
        list[0] = 0L
        list[1] = 1L
        list[2] = 2L
        for(i in 3 until list.size) {
            list[i] = (list[i-1] + list[i-2]) % 1234567
        }

        return list[n] % 1234567
    }
}