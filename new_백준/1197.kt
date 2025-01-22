import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue

lateinit var parent: MutableList<Int>
lateinit var visited: MutableList<Boolean>

data class Edge(
    val start: Int,
    val end: Int,
    val time: Long
)

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val (v, e) = br.readLine().split(" ").map { it.toInt() }

    parent = MutableList<Int>(v + 1) { it }

    val edges = mutableListOf<Edge>()

    repeat(e) {
        val (a, b, c) = br.readLine().split(" ").map { it.toLong() }
        edges.add(Edge(a.toInt(), b.toInt(), c))
    }

    edges.sortBy { it.time }

    var result = 0L

    for(i in 0 until edges.size) {
        val edge = edges[i]

        if(find(edge.start) != find(edge.end)) {
            union(edge.start, edge.end)
            result += edge.time
        }
    }

    bw.write(result.toString())
    bw.flush()
    bw.close()
}

fun find(a: Int): Int {
    if (a == parent[a]) {
        return a
    }

    parent[a] = find(parent[a])
    return parent[a]
}

fun union(num1: Int, num2: Int) {
    val a1 = find(num1)
    val b1 = find(num2)

    parent[b1] = a1
}
