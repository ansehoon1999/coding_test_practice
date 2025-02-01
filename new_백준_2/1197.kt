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
     * 스패닝 트리
     * 크루스칼
     */


    val (v, e) = br.readLine().split(" ").map { it.toInt() }

    val graph = hashMapOf<Int, MutableList<Node>>()
    val visited = MutableList<Boolean>(v + 1) { false }

    repeat(v) {
        graph[it + 1] = mutableListOf()
    }

    repeat(e) {
        val (a, b, c) = br.readLine().split(" ").map { it.toLong() }
        graph[a.toInt()]?.add(Node(b.toInt(), c))
        graph[b.toInt()]?.add(Node(a.toInt(), c))
    }

    fun prime(start: Int): Long {

        val pq = PriorityQueue<Node>({ p1, p2 ->
            (p1.cost - p2.cost).toInt()
        })
        var total = 0L

        pq.add(Node(start, 0))

        while(pq.isNotEmpty()) {
            val cur = pq.poll()

            if(visited[cur.to]) continue
            visited[cur.to] = true

            graph[cur.to]?.forEach { next ->
                if(!visited[next.to]) {
                    visited[next.to] = true
                    pq.add(next)
                }

            }

        }


        return total
    }

    println(prime(1))


    writer.flush()
    writer.close()
}