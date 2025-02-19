import java.io.BufferedReader
import java.io.InputStreamReader

data class Node(
    val num: Int,
    var left: Node? = null,
    var right: Node? = null
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     *
     */

    val n = br.readLine().toInt()

    val graph = hashMapOf<Int, MutableList<Int>>()

    repeat(n) {
        graph[it + 1] = mutableListOf()
    }

    val parents = MutableList<Int>(n+1) { it }
    val visited = MutableList<Boolean>(n+1) { false }

    repeat(n-1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt()}
        graph[a]?.add(b)
        graph[b]?.add(a)
    }

    val deque = ArrayDeque<Int>()
    deque.add(1)

    visited[1] = true

    while(deque.isNotEmpty()) {
        val cur = deque.removeFirst()

        graph[cur]?.forEach { next ->
            if(!visited[next]) {
                visited[next] = true
                deque.add(next)
                parents[next] = cur
            }
        }
    }

    for(i in 2 .. n) {
        println(parents[i])
    }



    writer.flush()
    writer.close()
}















