class Solution {
    fun solution(n: Long): Long {
        var answer: Long = 0

        val array = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)

        var curNum = n

        while(true) {
            if(curNum / 10 == 0L) {
                val els = (curNum % 10L).toInt()
                array[els] = array[els] + 1
                break
            }

            val els = (curNum % 10L).toInt()
            array[els] = array[els] + 1
            curNum = curNum / 10

        }

        var answerStr = ""
        for(idx in 9 downTo 0) {
            repeat(array[idx]) {
                answerStr = answerStr + idx
            }
        }



        return answerStr.toLong()
    }
}