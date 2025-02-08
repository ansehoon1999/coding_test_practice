import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue


data class Node(
    val to: Int,
    val weight: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val (v, e) = br.readLine().split(" ").map { it.toInt() }
    val k = br.readLine().toInt()

    val visited = MutableList<Boolean>(v + 1) { false }
    val weights = MutableList<Long>(v + 1) { Long.MAX_VALUE / 2 }

    val graph = hashMapOf<Int, MutableList<Node>>()

    repeat(v) {
        graph[it + 1] = mutableListOf()
    }

    repeat(e) {
        val (u, v2, w) = br.readLine().split(" ").map { it.toInt() }

        graph[u]?.add(Node(v2, w.toLong()))
    }

    graph.forEach {
        it.value.sortBy { it.weight }
    }

    val deque = PriorityQueue<Node>({ a, b ->
        (a.weight - b.weight).toInt()
    })
    deque.add(Node(k, 0))
    weights[k] = 0

    while (deque.isNotEmpty()) {
        val cur = deque.poll()

        if (visited[cur.to]) continue
        visited[cur.to] = true

        graph[cur.to]?.forEach { next ->
            val cost = weights[cur.to] + next.weight
            if (!visited[next.to] && weights[next.to] > cost) {
                weights[next.to] = cost
                deque.add(Node(next.to, cost))
            }

        }
    }


    for (i in 1 until weights.size) {
        if (weights[i] == Long.MAX_VALUE / 2) {
            println("INF")
        } else {
            println(weights[i])
        }
    }


    writer.flush()
    writer.close()
}


