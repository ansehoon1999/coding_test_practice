import java.util.*



data class Node (
    var weight : Int,
    var start : Int,
    var end :Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return weight - other.weight
    }

}


private lateinit var graph : MutableList<MutableList<Node>>
private lateinit var visited : MutableList<Boolean>
private var total = 0

fun main() {
    val sb = System.`in`.bufferedReader()
    val (s,e) = sb.readLine().split(' ').map { it.toInt() }

    graph = MutableList<MutableList<Node>>(s+1) { MutableList<Node>(0) { Node(0, 0, 0) } }
    visited = MutableList<Boolean>(s+1) { false }

    repeat(e) {
        val input = sb.readLine().split(' ').map { it.toInt() }
        graph[input[0]].add(Node(input[2], input[0], input[1]))
        graph[input[1]].add(Node(input[2], input[1], input[0]))
    }

    prim(1)
    
    println(total)
}

fun prim(start_node: Int) {
    visited[start_node] = true
    val candidate = graph[start_node]
    val queue = PriorityQueue<Node>()
    candidate.forEach {
        queue.add(it)
    }

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        if (!visited[node.end]) {
            visited[node.end] = true
            total += node.weight

            graph[node.end].forEach {
                if (!visited[it.end]) {
                    queue.add(it)
                }
            }
        }
    }

}


