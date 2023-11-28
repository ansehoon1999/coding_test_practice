class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray = IntArray(2)

        var totalCnt = 0
        var totalZero = 0

        var curStr = s

        while(curStr != "1") {

            val sList = curStr.toList()

            var count = 0
            sList.forEach { ch ->
                if(ch == '1') count++
            }

            totalCnt ++
            totalZero = totalZero + (sList.size - count)

            curStr = count.toString(2)

        }

        answer[0] = totalCnt
        answer[1] = totalZero

        return answer
    }
}