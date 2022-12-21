import java.util.PriorityQueue

private lateinit var result_dist : MutableList<MutableList<Int>>
private lateinit var list : MutableList<MutableList<Node>>
private val INF = Integer.MAX_VALUE

private class Node (var nodeNum: Int, var weight : Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return weight - other.weight
    }

}
fun main() = with(System.`in`.bufferedReader()){
    val input = readLine().split(' ').toList()
    val n = input[0].toInt() // n명의 학생
    val m = input[1].toInt() // m edge
    val x = input[2].toInt() // end

    list = MutableList<MutableList<Node>>(n+1) { MutableList<Node> (0) { Node(0,0)} }
    result_dist = MutableList<MutableList<Int>>(n+1) { MutableList<Int>(n+1) { INF } }


    repeat(m) {
        val input = readLine().split(' ').toList()
        list[input[0].toInt()].add(Node(input[1].toInt(), input[2].toInt()))
    }

    for(i in 1 .. n) {
        val eachdist = dijkstra(i, n)
        for (j in 1 .. n) {
            result_dist[i][j] = eachdist[j]
        }
    }

//    result_dist.forEach {
//        println(it)
//    }
    var result = -1
    for (i in 1 .. n) {
        result = Math.max(result, result_dist[x][i] + result_dist[i][x])
    }

    println(result)

}

fun dijkstra(start: Int, n:Int) : MutableList<Int> {
    val dist = MutableList<Int>(n+1) { INF }
    val visited = MutableList<Boolean>(n+1) { false }

    dist[start] = 0
    val pq = PriorityQueue<Node>()
    pq.offer(Node(start, 0))

    while (pq.isNotEmpty()) {
        val node = pq.poll()
        if (!visited[node.nodeNum]) {
            visited[node.nodeNum] = true

            list[node.nodeNum].forEach {
                if (!visited[it.nodeNum] && dist[it.nodeNum] > dist[node.nodeNum] + it.weight) {
                    dist[it.nodeNum] = dist[node.nodeNum] + it.weight
                    pq.add(Node(it.nodeNum, dist[it.nodeNum]))
                }
            }

        }
    }

    return dist
}
