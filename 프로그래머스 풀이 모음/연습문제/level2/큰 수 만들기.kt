import java.util.*

class Solution {

    fun solution(number: String, k: Int): String {
        var answer = ""

        val stk = Stack<Int>()

        var kCnt = k
        val numList = number.toList().map { it.toString().toInt() }

        for(i in 0 until numList.size) {

            val cur = numList[i].toInt()

            while(stk.isNotEmpty()) {

                if(kCnt == 0) break

                val last = stk.peek()

                if(last < cur) {
                    stk.pop()
                    kCnt --
                } else {
                    break
                }

            }

            stk.add(cur)
        }


        val sb = StringBuilder()

        if(kCnt == 0) {
            for(i in 0 until stk.size) {
                sb.append(stk[i].toString())
            }
        } else {
            for(i in 0 until stk.size - kCnt) {
                sb.append(stk[i].toString())
            }
        }

        return sb.toString()

    }
}