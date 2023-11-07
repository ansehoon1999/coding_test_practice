class Solution {
    fun solution(n: Long): IntArray {
        var answer = mutableListOf<Int>()

        var curNum = n

        while(true) {
            if(curNum / 10 == 0L) {
                val els = (curNum % 10L).toInt()
                answer.add(els)
                break
            }

            val els = (curNum % 10L).toInt()
            answer.add(els)
            curNum = curNum / 10

        }

        answer.reversed()
        return answer.toIntArray()
    }
}