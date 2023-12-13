import java.util.*

class Solution {
    fun solution(order: IntArray): Int {
        var answer: Int = 0

        val stk = Stack<Int>()

        var i = 1

        while(i != (order.size + 1)) {

            stk.add(i)

            while(stk.isNotEmpty() && stk.last() == order[answer]) {
                answer ++
                stk.pop()
            }

            i ++
        }

        return answer
    }



}