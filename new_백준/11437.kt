import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer


data class Node(
    val num: Int,
    val depth: Int
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()
    val N = StringTokenizer(br.readLine()).nextToken().toInt()

    val parent = MutableList<Int>(N+1) { it }
    val depth = MutableList<Int>(N+1) { 0 }
    val visited = MutableList<Boolean>(N+1) { false}

    val graph = HashMap<Int, MutableList<Int>>()
    repeat(N) {
        graph[it+1] = mutableListOf()
    }

    repeat(N - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a]?.add(b)
        graph[b]?.add(a)
    }

    fun bfs(node: Int) {

        val queue: Queue<Int> = LinkedList()
        queue.add(node)
        visited[node] = true
        while (queue.isNotEmpty()) {
            val nowNode = queue.poll()
            for (next in graph[nowNode]!!) {
                if (!visited[next]) {
                    visited[next] = true
                    queue.add(next)
                    parent[next] = nowNode
                    depth[next] = depth[nowNode] + 1
                }
            }
        }
    }
    
    fun bfs1(start: Int) {
        val deque = ArrayDeque<Node>()
        deque.add(Node(start,1))
        visited[start] = true

        while (deque.isNotEmpty()) {
            val cur = deque.removeFirst()
            val curNum = cur.num
            val curDepth = cur.depth

            graph[curNum]?.forEach { next ->

                if(!visited[next]) {
                    visited[next] = true
                    parent[next] = curNum
                    depth[next] = curDepth
                    deque.add(Node(next, curDepth + 1))
                }
            }
        }
    }

    bfs1(1)


//    println(parent)
//    println(depth)

    fun executeLCA(a: Int, b: Int): Int {
        var a1 = a
        var b1 = b

        if(depth[a1] < depth[b1]) {
            val temp = a1
            a1 = b1
            b1 = temp
        }

        while(depth[a1] != depth[b1]) {
            a1 = parent[a1]
        }

        while(a1 != b1) {
            a1 = parent[a1]
            b1 = parent[b1]
        }

        return a1
    }

    val M = StringTokenizer(br.readLine()).nextToken().toInt()
    repeat(M) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        val lca = executeLCA(a, b)

        writer.write("${lca}\n")
    }

    writer.flush()
    writer.close()


}