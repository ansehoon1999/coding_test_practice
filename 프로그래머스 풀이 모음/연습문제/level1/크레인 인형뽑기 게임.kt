import java.util.*

class Solution {

    val stk = Stack<Int>()
    var answer = 0

    fun solution(board: Array<IntArray>, moves: IntArray): Int {

        moves.forEach { move ->

            for(col in 0 until board.size) {
                if(board[col][move-1] != 0) {
                    stackAdd(board[col][move-1])
                    board[col][move-1] = 0
                    break
                }
            }

            // board.forEach {
            //     println(it.toList().toString())
            // }
            // println("stk: " + stk.toString())
        }



        return answer
    }

    fun stackAdd(doll: Int) {
        if(stk.isEmpty()) {
            stk.add(doll)
        } else {
            val last = stk.last()
            if(doll == last) {
                stk.pop()
                answer += 2
            } else {
                stk.add(doll)
            }
        }
    }
}