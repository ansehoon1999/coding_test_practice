class Solution {

    fun solution(n: Int): Int {
        var answer = 0

        var list = LongArray(n+1)
        list[0] = 0L
        list[1] = 1L
        list[2] = 1L

        for(i in 3 until list.size) {
            list[i] = (list[i-1] + list[i-2]) % 1234567L
        }


        return list[n].toInt()
    }
}