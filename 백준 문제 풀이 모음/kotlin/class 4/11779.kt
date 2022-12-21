import java.util.PriorityQueue

private const val INF = Integer.MAX_VALUE
private lateinit var dist : MutableList<Int>
private lateinit var list : MutableList<MutableList<Node>>
private lateinit var visited : MutableList<Boolean>
private lateinit var back : MutableList<Int>

private class Node (var nodeNum : Int, var weight :Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return weight - other.weight
    }
}

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val m = readLine().toInt()

    dist = MutableList<Int>(n+1) { INF }
    list = MutableList<MutableList<Node>>(n+1) { MutableList<Node>(0) { Node(0,0)} }
    visited =MutableList<Boolean>(n+1) { false }
    back = MutableList<Int> (n+1) { 0 }
    for (i in 0 .. n) {
        back[i] = i
    }

    repeat(m) {
        val input = readLine().split(' ').toList()
        list[input[0].toInt()].add(Node(input[1].toInt(), input[2].toInt()))
    }

    val input = readLine().split(' ').toList()
    val start = input[0].toInt()
    val end = input[1].toInt()

    dijkstra(start, n)

    println(dist[end])

    var path = mutableListOf<Int>()
    path.add(end)

    var now = end
    while (now != start ) {
        now = back[now]
        path.add(now)
    }
    println(path.size)
    for (i in path.size -1 downTo 0) {
        print(path[i])
        print(' ')
    }

}

fun dijkstra(start: Int, n: Int) {
    dist[start] = 0
    val pq = PriorityQueue<Node>()
    pq.offer(Node(start, 0))

    while (pq.isNotEmpty()) {
//        pq.forEach {
//            print(it.nodeNum)
//            print(' ')
//        }
//        println()
        val node = pq.poll()
//        println(node.nodeNum)
        if (!visited[node.nodeNum]) {
            visited[node.nodeNum] = true
            list[node.nodeNum].forEach {
                if (!visited[it.nodeNum] && dist[it.nodeNum] > dist[node.nodeNum] + it.weight) {
                    dist[it.nodeNum] = dist[node.nodeNum] + it.weight
                    pq.offer(Node(it.nodeNum, dist[it.nodeNum]))
                    back[it.nodeNum] = node.nodeNum
                }
            }
        }
    }
}




