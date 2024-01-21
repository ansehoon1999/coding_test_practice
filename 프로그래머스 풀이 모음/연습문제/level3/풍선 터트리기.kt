class Solution {
    fun solution(a: IntArray): Int {
        var answer: Int = 0

        val result = MutableList<Boolean>(a.size) { false }

        var minFront = Integer.MAX_VALUE
        var minRear = Integer.MAX_VALUE

        for(i in 0 until a.size) {
            if(a[i] < minFront) {
                minFront = a[i]
                result[i] = true
            }

            if(a[a.size - 1 - i] < minRear) {
                minRear = a[a.size - 1 - i]
                result[a.size - 1 - i] = true
            }
        }

        result.forEach {
            if(it) answer ++
        }


        return answer
    }
}