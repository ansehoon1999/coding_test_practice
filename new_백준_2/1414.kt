import java.io.BufferedReader
import java.io.InputStreamReader


data class Edge(
    val from: Int,
    val to: Int,
    val cost: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()


    /**
     * 크루스칼 알고리즘
     */

    val n = br.readLine().toInt()

    val edges = mutableListOf<Edge>()
    var edgeSum = 0

    repeat(n) { i ->
        val tmp = br.readLine().map {
            if (it.isUpperCase()) {
                it - 'A' + 27
            } else if (it.isLowerCase()) {
                it - 'a' + 1
            } else {
                it.toString().toInt()
            }
        }


        tmp.forEachIndexed { j, cost ->
            if (i != j && cost != 0) {
                edges.add(Edge(i + 1, j + 1, cost.toLong()))
            }

            edgeSum += cost
        }
    }

    edges.sortBy { it.cost }

    val parents = MutableList<Int>(n + 1) { it }

    fun find(a: Int): Int {
        if (a == parents[a]) return a
        else {
            parents[a] = find(parents[a])
            return parents[a]
        }
    }

    fun union(a: Int, b: Int) {
        val a = find(a)
        val b = find(b)

        if (b != a) {
            parents[b] = a
        }
    }


    var usage = 0L
    for (i in 0 until edges.size) {
        if (find(edges[i].to) != find(edges[i].from)) {
            union(edges[i].to, edges[i].from)
            usage += edges[i].cost
        }
    }

    var tmp = find(parents[1])


    for(i in 2 until parents.size) {
        if(tmp != find(parents[i])) {
            println(-1)
            return
        }
    }

    println(edgeSum - usage)


    writer.flush()
    writer.close()
}


