import java.util.PriorityQueue

private const val INF = Integer.MAX_VALUE / 2
private lateinit var dist : IntArray
private lateinit var list : MutableList<MutableList<Node>>

private class Node (var nodeNum : Int, var weight : Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return weight - other.weight
    }

}

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val m = readLine().toInt()

    dist = IntArray(n+1) { INF }
    list = ArrayList()
    repeat(n+1) {
        list.add(ArrayList())
    }

    repeat(m) {
        val input = readLine().split(' ').toList()
        val start = input[0].toInt()
        val end = input[1].toInt()
        val weight = input[2].toInt()

        list.get(start).add(Node(end, weight))
    }

    val str = readLine().split(' ').toList()
    val start = str[0].toInt()
    val end = str[1].toInt()

    println(dijkstra(start, end, n, m))

}

fun dijkstra(start: Int, end: Int, n:Int, m:Int): Int {
    val deque = PriorityQueue<Node>()
    val visited = MutableList<Boolean>(n+1) { false }
    dist[start] = 0
    deque.add(Node(start, 0))

    while (deque.isNotEmpty()) {
        val node = deque.poll()
        var start_node = node.nodeNum

        if (!visited[start_node]) {
            visited[start_node] = true

            list.get(start_node).forEach {
                if (!visited[it.nodeNum] && dist[it.nodeNum] > dist[start_node] + it.weight) {
                    dist[it.nodeNum] = dist[start_node] + it.weight
                    deque.offer(Node(it.nodeNum, dist[it.nodeNum]))
                }
            }
        }

    }
    return dist[end]
}
