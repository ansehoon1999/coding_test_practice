import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

data class Node(
    val to: Int,
    val cost: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     * 1. 다익스트라 알고리즘
     */

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val hashMap = hashMapOf<Int, MutableList<Node>>()

    repeat(n) {
        hashMap[it + 1] = mutableListOf()
    }

    repeat(m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        hashMap[a]?.add(Node(b, c.toLong()))
    }

    val (start, end) = br.readLine().split(" ").map { it.toInt() }

    val visited = MutableList<Boolean>(n + 1) { false }

    val dists = MutableList<Long>(n + 1) { Long.MAX_VALUE / 2 }

    val deque = PriorityQueue<Node>({a, b ->
        (a.cost - b.cost).toInt()
    })
    deque.add(Node(start, 0L))
    dists[start] = 0L

    while (deque.isNotEmpty()) {
        val cur = deque.poll()

        if(visited[cur.to]) continue
        visited[cur.to] = true

        hashMap[cur.to]?.forEach { next ->
            val cost = dists[cur.to] + next.cost

            if (dists[next.to] > cost) {
                dists[next.to] = cost
                deque.add(Node(next.to, cost))
            }
        }
    }

    println(dists[end])

    writer.flush()
    writer.close()
}

