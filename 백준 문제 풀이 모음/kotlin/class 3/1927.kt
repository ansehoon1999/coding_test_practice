package class3

import java.util.PriorityQueue

fun main () = with(System.`in`.bufferedReader()) {
    val pq = PriorityQueue<Int> ()

    val n = readLine().toInt()

    val sb = StringBuilder()
    repeat(n) {
        val input = readLine().toInt()

        if (input == 0) {
            if (pq.size == 0) {
                sb.append(0)
            } else {
                sb.append(pq.remove())
            }
            sb.append('\n')
        } else {
            pq.add(input)
        }
    }

    print(sb.toString())

}