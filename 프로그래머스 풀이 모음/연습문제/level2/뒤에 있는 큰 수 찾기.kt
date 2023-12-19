import java.util.*

class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer = Array<Int>(numbers.size) { -1 }

        val stk = Stack<Int>()

        for(idx in 0 until numbers.size) {

            while(stk.isNotEmpty() && numbers[stk.peek()] < numbers[idx]) {
                answer[stk.pop()] = numbers[idx]
            }

            stk.add(idx)

        }


        return answer.toIntArray()
    }
}