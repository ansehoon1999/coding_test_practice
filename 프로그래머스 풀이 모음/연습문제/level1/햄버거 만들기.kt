import java.util.*

class Solution {
    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0

        val stk = Stack<Int>()

        for(idx in 0 until ingredient.size) {

            if(stk.size < 3) {
                stk.add(ingredient[idx])
                continue
            }

            if(ingredient[idx] == 1) {
                val stkSize = stk.size

                if(stk[stkSize - 1] == 3 && stk[stkSize - 2] == 2 && stk[stkSize - 3] == 1) {
                    stk.pop()
                    stk.pop()
                    stk.pop()

                    answer ++
                    continue
                }
            }
            stk.add(ingredient[idx])
        }


        return answer

    }
}