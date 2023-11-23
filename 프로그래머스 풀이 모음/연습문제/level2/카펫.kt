class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = IntArray(2)

        val total = brown + yellow

        val sqrt = Math.sqrt(yellow.toDouble()).toInt()

        for(i in 1 .. sqrt) {
            if(yellow % i == 0) {
                val one = yellow / i
                val two = i

                if((one + 2) * (two + 2) == total) {
                    answer[0] = maxOf(one + 2, two + 2)
                    answer[1] = minOf(one + 2, two + 2)
                    return answer
                }
            }
        }


        return answer


    }
}