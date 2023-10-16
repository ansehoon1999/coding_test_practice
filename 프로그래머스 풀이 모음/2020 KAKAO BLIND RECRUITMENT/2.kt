import java.util.*

class Solution {
    fun solution(p: String): String {

        return makeAlright(p)
    }

    fun makeAlright(p: String): String {

        if(isAlright(p) || p == "") return p

        var answer = ""
        var u = ""
        var v = ""

        for(i in 2 .. p.length step(2)) {

            if(isBalanced(p.substring(0, i))) {
                u = p.substring(0, i)
                v = p.substring(i, p.length)
                break
            }
        }

        if(isAlright(u)) {
            answer += u + makeAlright(v)
        } else {
            answer += '(' + makeAlright(v) + ')'
            for(c in 1 until u.length - 1) {
                answer += if(u[c] =='(') ')'
                else '('
            }
        }

        return answer
    }

    fun isBalanced(p: String): Boolean {
        var totalCount = 0

        for(i in p) {
            if(i == '(') {
                totalCount ++
            } else {
                totalCount --
            }
        }

        return totalCount == 0
    }


    fun isAlright(p: String): Boolean {

        val pList = p.toList()

        val stk = Stack<Char>()

        pList.forEach {

            if(stk.isNotEmpty()) {

                val stkLast = stk.lastElement()
                if(stkLast == '(' && it == ')') {
                    stk.removeLast()
                } else {
                    stk.add(it)
                }
            } else {
                stk.add(it)
            }
        }

        return stk.isEmpty()
    }
}