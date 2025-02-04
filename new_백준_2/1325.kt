import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import kotlin.math.cos

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()


    /**
     *
     * bfs
     */

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = hashMapOf<Int, MutableList<Int>>()

    repeat(n) {
        graph[it + 1] = mutableListOf()
    }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[b]?.add(a)
    }

    val cost = MutableList<Int>(n+1) { 0 }

    var maxResult = 0



    repeat(n) {
        val now = it+1

        val visited = MutableList<Boolean>(n+1) { false }

        val deque = ArrayDeque<Int>()
        deque.add(now)
        visited[now] = true
        var cnt =  0

        while(deque.isNotEmpty()) {
            val cur = deque.removeFirst()

            graph[cur]?.forEach { next ->
                if(!visited[next]) {
                    visited[next] = true
                    cnt ++
                    deque.add(next)
                }
            }
        }

        cost[now] = maxOf(cnt, cost[now])
        maxResult = maxOf(maxResult, cost[now])
    }

    val sb = StringBuilder()
    for(i in 1 until cost.size) {
        if(cost[i] == maxResult) {
            sb.append("${i} ")
        }
    }

    writer.write(sb.toString())
    writer.flush()
    writer.close()
}


