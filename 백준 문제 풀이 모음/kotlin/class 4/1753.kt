import java.util.PriorityQueue


private lateinit var dist : MutableList<Int>
private lateinit var list : MutableList<MutableList<Node>>
private lateinit var visited : MutableList<Boolean>
val INF = Integer.MAX_VALUE

class Node (var nodeNum : Int, var weight : Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return weight - other.weight
    }

}

fun main() = with(System.`in`.bufferedReader()){
    val input = readLine().split(' ').toList()
    val v = input[0].toInt()
    val e = input[1].toInt()

    val start = readLine().toInt()

    dist = MutableList<Int>(v+1) { INF }
    visited = MutableList<Boolean>(v+1) { false }

    list = MutableList<MutableList<Node>>(v+1) { MutableList<Node> (0) { Node(0,0) }  }
    repeat(e) {
        val input = readLine().split(' ').toList()
        val u = input[0].toInt()
        val v = input[1].toInt()
        val w = input[2].toInt()

        list[u].add(Node(v, w))
    }

    dijkstra(start, v, e)

//    println(dist)
    val sb = StringBuilder()
    for (i in 0 .. v) {
        if (i == 0) continue

        if (dist[i] == INF) {
            sb.append("INF")
        } else {
            sb.append(dist[i])
        }
        sb.append('\n')

    }
    println(sb.toString())

}

fun dijkstra(start: Int, v: Int, e: Int) {
    dist[start] = 0
    val pq = PriorityQueue<Node>()
    pq.add(Node(start, 0))

    while (pq.isNotEmpty()) {
        val node = pq.poll()

        if (visited[node.nodeNum] == false) {
            visited[node.nodeNum] = true

            list[node.nodeNum].forEach {
                if (!visited[it.nodeNum] && dist[it.nodeNum] > dist[node.nodeNum] + it.weight) {
                    dist[it.nodeNum] = dist[node.nodeNum] + it.weight
                    pq.offer(Node(it.nodeNum, dist[it.nodeNum]))
                }
            }
        }

    }
}
