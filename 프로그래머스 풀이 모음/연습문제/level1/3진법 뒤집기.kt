import kotlin.math.*

class Solution {
    fun solution(n: Int): Int {

        var curN = n
        var result = ""

        while(true) {

            val divided = curN / 3
            val elsed = curN % 3

            if(divided == 0) {
                result = elsed.toString() + result
                break
            }

            result = elsed.toString() + result
            curN = divided
        }

        var curCnt = 1


        var answer: Double = 0.0

        while(curCnt <= result.length) {

            answer = answer + 3.0.pow(curCnt-1) * result[curCnt-1].toString().toInt()

            curCnt ++
        }

        return answer.toInt()
    }
}