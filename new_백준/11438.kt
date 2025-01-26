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

    val tree = hashMapOf<Int, MutableList<Int>>()

    repeat(N) {
        tree[it+1] = mutableListOf()
    }

    repeat(N-1) {
        val (s, e) = br.readLine().split(" ").map { it.toInt() }
        tree[s]?.add(e)
        tree[e]?.add(s)
    }

    val depth = MutableList<Int>(N + 1) { 0 }
    val visited = MutableList<Boolean>(N + 1) { false }

    var temp = 1
    var kmax = 0

    while(temp <= N) {
        kmax ++
        temp = temp shl 1
    }

    val parent = MutableList<MutableList<Int>>(kmax + 1) {
        MutableList<Int>(N+1) { 0 }
    }

    fun bfs(node: Int) {
        val deque = ArrayDeque<Node>()
        deque.add(Node(node, 1))
        visited[node] = true

        while(deque.isNotEmpty()) {
            val now = deque.removeFirst()
            val nowNum = now.num
            val nowDepth = now.depth

            tree[nowNum]?.forEach { next ->
                if(!visited[next]) {
                    visited[next] = true
                    parent[0][next] = now.num
                    depth[next] = nowDepth
                    deque.add(Node(next, nowDepth + 1))
                }
            }
        }
    }

    bfs(1)

    for(k in 1 .. kmax) {
        for(n in 1 .. N) {
            parent[k][n] = parent[k - 1][parent[k-1][n]]
        }
    }

    fun executeLCA(a: Int, b: Int): Int {
        var a1 = a
        var b1 = b

        if(depth[a1] > depth[b1]) {
            val temp = a1
            a1 = b1
            b1 = temp
        }

        for(k in kmax downTo 0) {
            if(Math.pow(2.0, k.toDouble()) <= depth[b1] - depth[a1]) {
                if(depth[a1] <= depth[parent[k][b1]]) {
                    b1 = parent[k][b1]
                }
            }
        }

        for(k in kmax downTo 0) {
            if(a1 == b1) break
            if(parent[k][a1] != parent[k][b1]) {
                a1 = parent[k][a1]
                b1 = parent[k][b1]
            }
        }

        var LCA = a1
        if(a1 != b1) {
            LCA = parent[0][LCA]
        }
        return LCA
    }



    val M = br.readLine().toInt()
    repeat(M) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        val tmp = executeLCA(minOf(a, b), maxOf(a, b))
        writer.write("${tmp}\n")
    }

    writer.flush()
    writer.close()

}