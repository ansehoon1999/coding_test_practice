import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

data class Node(
    val to: Int,
    val time: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val graph = mutableMapOf<Int, MutableList<Node>>()
    val reverseGraph = mutableMapOf<Int, MutableList<Node>>()

    repeat(n) {
        graph[it + 1] = mutableListOf()
        reverseGraph[it + 1] = mutableListOf()
    }

    val inDegrees = MutableList<Int>(n+1) { 0 }

    repeat(m) {
        val (s, e, w) = br.readLine().split(" ").map { it.toInt() }
        graph[s]?.add(Node(e, w.toLong()))
        reverseGraph[e]?.add(Node(s, w.toLong()))
        inDegrees[e] += 1
    }

    val (s, e) = br.readLine().split(" ").map { it.toInt() }

    val distances = MutableList<Long>(n+1) { 0 }


    fun bfs(start: Int) {
        val deque = ArrayDeque<Int>()
        deque.add(start)

        while(deque.isNotEmpty()) {
            val cur = deque.removeFirst()
            graph[cur]?.forEach { next ->

                inDegrees[next.to] -= 1
                distances[next.to] = maxOf(distances[next.to], distances[cur] + next.time)

                if(inDegrees[next.to] == 0) {
                    deque.add(next.to)
                }
            }
        }
    }


    bfs(s)

    val deque = ArrayDeque<Int>()
    deque.add(e)

    val visited = MutableList<Boolean>(n+1) { false }
    var cnt = 0

    while(deque.isNotEmpty()) {
        val cur = deque.removeFirst()

        reverseGraph[cur]?.forEach { next ->

            if(distances[cur] == distances[next.to] + next.time) {
                cnt ++

                if (!visited[next.to]) {
                    visited[next.to] = true
                    deque.add(next.to)
                }
            }
        }
    }


    println(distances[e])
    println(cnt)



    bw.flush()
    bw.close()
    br.close()
}

