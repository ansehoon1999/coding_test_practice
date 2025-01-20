import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val now = br.readLine().split(" ").map { it.toInt() }
    val visited = MutableList<MutableList<Boolean>>(201) {
        MutableList<Boolean>(201) { false }
    }

    val sender = intArrayOf(0, 0, 1, 1, 2, 2)
    val receiver = intArrayOf(1, 2, 0, 2, 0, 1)

    val result = MutableList<Boolean>(201) { false }

    val deque = ArrayDeque<Pair<Int, Int>>()
    deque.add(Pair(0, 0))
    visited[0][0] = true
    result[now[2]] = true

    while (deque.isNotEmpty()) {
        println(deque)

        val curNode = deque.removeFirst()
        val a = curNode.first
        val b = curNode.second
        val c = now[2] - a - b

        for (k in 0 until 6) {
            val next = intArrayOf(a, b, c)

            next[receiver[k]] += next[sender[k]]
            next[sender[k]] = 0

            if (next[receiver[k]] > now[receiver[k]]) {
                next[sender[k]] = (next[receiver[k]] - now[receiver[k]])
                next[receiver[k]] = now[receiver[k]]
            }

            if (!visited[next[0]][next[1]]) {
                visited[next[0]][next[1]] = true
                deque.add(Pair(next[0], next[1]))

                println(next.toList())
                if(next[0] == 0) {
                    result[next[2]] = true
                }
            }
        }

    }

    for(idx in 0 until result.size) {
        if(result[idx]) {
            println("$idx ")
        }
    }

    bw.flush()
    bw.close()

}


S