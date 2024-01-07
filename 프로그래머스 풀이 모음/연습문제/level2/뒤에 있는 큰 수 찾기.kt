import java.util.*

class Solution {

    val stk = Stack<Pair<Int, Int>>()

    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = IntArray(numbers.size)

        for(idx in 0 until numbers.size) {

            while(stk.isNotEmpty()) {

                val last = stk.last()
                val lastIdx = last.first
                val lastNum = last.second

                if(numbers[idx] > lastNum) {
                    answer[lastIdx] = numbers[idx]
                    stk.pop()
                } else {
                    break
                }
            }

            stk.push(Pair(idx, numbers[idx]))

            // println("answer: ${answer.toList()}")
            // println("stk: ${stk.toList()}")
        }

        while(stk.isNotEmpty()) {
            val last = stk.pop()
            val idx = last.first
            val cost = last.second

            answer[idx] = -1
        }

        return answer
    }
}