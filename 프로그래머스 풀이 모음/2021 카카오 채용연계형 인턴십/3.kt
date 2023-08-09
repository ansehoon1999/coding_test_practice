import java.util.*

class Solution {

    private var curPosition = 0
    private var backStk = Stack<Int>()
    private var total = 0

    fun solution(n: Int, k: Int, cmd: Array<String>): String {

        val resultArray = Array<String>(n) { "O" }

        curPosition = k
        total = n

        cmd.forEach {
            val state = it.split(" ")
            val op = state[0]

            when(op) {
                "U" -> {
                    curPosition -= state[1].toInt()
                }
                "D" -> {
                    curPosition += state[1].toInt()
                }
                "C" -> {
                    total -= 1
                    backStk.add(curPosition)
                    if(curPosition == total) {
                        curPosition -= 1
                    }
                }
                "Z" -> {
                    val pop = backStk.pop()

                    total += 1

                    if(pop <= curPosition) {
                        curPosition += 1
                    }
                }
            }
        }

        val sb = StringBuilder()
        sb.append("O".repeat(total))

        while(!backStk.isEmpty()) {
            sb.insert(backStk.pop(), 'X')

        }


        return sb.toString()
    }

}