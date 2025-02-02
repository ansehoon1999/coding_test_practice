import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

data class Node(
    val to: Int,
    val weight: Int
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val graph = hashMapOf<Int, MutableList<Node>>()

    val n = br.readLine().toInt()

    repeat(n) {
        graph[it + 1] = mutableListOf()
    }

    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val start = st.nextToken().toInt()

        while (true) {

            val cur = st.nextToken().toInt()

            if (cur == -1) break

            graph[start]?.add(
                Node(
                    cur, st.nextToken().toInt()
                )
            )
        }
    }

    var maxLength = 0
    var maxIdx = 1

    fun dfs(start: Int, len: Int, visited: MutableList<Boolean>) {

        if(maxLength <= len) {
            maxLength = len
            maxIdx = start
        }

        visited[start] = true

        graph[start]?.forEach { next ->
            if(!visited[next.to]) {

                dfs(next.to, len + next.weight, visited)
            }
        }
    }

    fun bfs(start: Int, visited: MutableList<Boolean>) {

        val deque = ArrayDeque<Node>()
        deque.add(Node(start, 0))
        visited[start] = true

        while (deque.isNotEmpty()) {
            val curNode = deque.removeFirst()

            graph[curNode.to]?.forEach { nextNode ->
                if(!visited[nextNode.to]) {
                    visited[nextNode.to] = true

                    deque.add(Node(nextNode.to, curNode.weight + nextNode.weight))

                    if(maxLength <= curNode.weight + nextNode.weight) {
                        maxLength = maxOf(maxLength, curNode.weight + nextNode.weight)
                        maxIdx = nextNode.to
                    }
                }

            }
        }

    }

    var visited = MutableList<Boolean>(n+1) { false }
    dfs(1, 0, visited)

    visited = MutableList<Boolean>(n+1) { false }

    dfs(maxIdx, 0, visited)

    println(maxLength)

    writer.flush()
    writer.close()
}