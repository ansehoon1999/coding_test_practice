class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0

        var x = s[0]
        var xCount = 1
        var yCount = 0

        for(sIdx in 1 until s.length) {

            if(xCount == 0 && yCount == 0) {
                x = s[sIdx]
            }

            val curChar = s[sIdx]

            if(curChar == x) {
                xCount ++
            } else {
                yCount ++
            }

            if(xCount == yCount) {
                xCount = 0
                yCount = 0
                answer ++
            }
        }

        if(xCount == 0 && yCount == 0) return answer
        else return answer+1

    }
}