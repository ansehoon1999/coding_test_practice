import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.math.cos

data class Node(
    val to: Int,
    val value: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()


    val (n, m, k, x) = br.readLine().split(" ").map { it.toInt() }

    val graph = hashMapOf<Int, MutableList<Node>>()

    val INF = Long.MAX_VALUE

    val visited = MutableList<Boolean>(n+1) { false }
    val distances = MutableList<Long>(n+1) { INF }

    repeat(n) {
        graph[it+1] = mutableListOf()
    }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a]?.add(Node(b, 1))
    }

//    println(graph)

    val pq = PriorityQueue<Node>({ a, b ->
        (a.value - b.value).toInt()
    })

    pq.add(Node(x, 0))
    distances[x] = 0

    while(pq.isNotEmpty()) {
        val cur = pq.poll()

        if(visited[cur.to]) continue
        visited[cur.to] = true

        graph[cur.to]?.forEach { next ->
            val cost = distances[cur.to] + next.value
            if(!visited[next.to] && distances[next.to] > cost) {
                distances[next.to] = cost
                pq.add(Node(next.to,  cost))
            }
        }
    }

    var flag = true

    for(i in 1 .. n) {
        if(distances[i].toInt() == k) {
            println(i)
            flag = false
        }
    }

    if(flag) {
        println(-1)
    }


    writer.flush()
    writer.close()
}














