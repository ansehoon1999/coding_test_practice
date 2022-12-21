import java.util.PriorityQueue

private const val INF = Integer.MAX_VALUE / 2
private lateinit var list : MutableList<MutableList<Node>>
private lateinit var item_list : List<Int>
private class Node (var NodeNum : Int, var weight : Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return weight - other.weight
    }
}

fun main() = with(System.`in`.bufferedReader()){
    val input = readLine().split(' ').toList()
    val n = input[0].toInt()
    val m = input[1].toInt()
    val r = input[2].toInt()


    list = MutableList<MutableList<Node>> (n+1) { MutableList<Node>(0) { Node(0,0)} }

    item_list = readLine().split(' ').toList().map { it.toInt() }
    repeat(r) {
        val input = readLine().split(' ').toList()
        list[input[0].toInt()].add(Node(input[1].toInt(), input[2].toInt()))
        list[input[1].toInt()].add(Node(input[0].toInt(), input[2].toInt()))
    }

    var result = - 1
    for (i in 1 .. n) {
        result = Math.max(result, dikjstra(i, n, m))
    }

    println(result)

}

fun dikjstra(start: Int, n: Int, m :Int) : Int {
    val visited = MutableList<Boolean>(n+1) { false }
    val dist = MutableList<Int>(n+1) { INF }

    dist[start] = 0
    val pq = PriorityQueue<Node>()
    pq.offer(Node(start, 0))

    while (pq.isNotEmpty()) {
        val node = pq.poll()

        if (!visited[node.NodeNum]) {
            visited[node.NodeNum] = true

            list[node.NodeNum].forEach {
                if (!visited[it.NodeNum] && dist[it.NodeNum] > dist[node.NodeNum] + it.weight) {
                    dist[it.NodeNum] = dist[node.NodeNum] + it.weight
                    pq.offer(Node(it.NodeNum, dist[it.NodeNum]))
                }
            }
        }
    }

    var cost = 0
    for (i in 1 .. n) {
        if (dist[i] <= m) {
            cost += item_list[i-1]
        }
    }
//    println(dist)
    return cost
}
