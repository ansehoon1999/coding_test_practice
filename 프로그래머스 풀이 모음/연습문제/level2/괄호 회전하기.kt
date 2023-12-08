import java.util.*

class Solution {

    val deque = ArrayDeque<Char>()

    fun solution(s: String): Int {
        var answer: Int = 0

        s.forEach {
            deque.add(it)
        }

        repeat(s.length) {

            if(rotate()) answer ++

            val first = deque.pop()
            deque.add(first)
        }

        return answer
    }

    fun rotate() : Boolean {
        val stk = Stack<Char>()

        deque.forEach { cur ->
            if(stk.isEmpty()) {
                stk.add(cur)
            } else {
                if(cur == ']' && stk.last() == '[') {
                    stk.pop()
                } else if(cur == ')' && stk.last() == '(') {
                    stk.pop()
                } else if(cur == '}' && stk.last() == '{') {
                    stk.pop()
                } else {
                    stk.add(cur)
                }
            }

        }

        return stk.isEmpty()
    }
}