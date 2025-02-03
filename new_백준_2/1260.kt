import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue



fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     * n, m, v
     *
     */

    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }

    var visited = MutableList<Boolean>(n+1) { false }
    val graph = hashMapOf<Int, MutableList<Int>>()

    repeat(n) {
        graph[it+1] = mutableListOf()
    }


    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a]?.add(b)
        graph[b]?.add(a)
    }

    graph.forEach {
        it.value.sort()
    }

    val sb = StringBuilder()

    fun dfs(start: Int) {

        visited[start] = true
        sb.append("${start} ")

        graph[start]?.forEach { next ->
            if(!visited[next]) {
                dfs(next)
            }
        }
    }

    visited[v] = true
    dfs(v)

    println(sb.toString())

    visited = MutableList<Boolean>(n+1) { false }
    val sb2 = StringBuilder()

    fun bfs(start: Int) {
        val deque = ArrayDeque<Int>()
        deque.add(start)

        while(deque.isNotEmpty()) {
            val cur = deque.removeFirst()

            if(visited[cur]) continue
            visited[cur] = true
            sb2.append("${cur} ")

            graph[cur]?.forEach { next ->
                if(!visited[next]) {
                    deque.add(next)
                }
            }
        }
    }

    bfs(v)
    println(sb2.toString())




    writer.flush()
    writer.close()
}
