import java.util.PriorityQueue

private const val INF = 200000001
private lateinit var list : MutableList<MutableList<Node>>

private class Node (var nodeNum :Int, var weight : Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return weight - other.weight
    }
}

fun main() = with(System.`in`.bufferedReader()){
    val input = readLine().split(' ').toList()
    val n = input[0].toInt()
    val e = input[1].toInt()

    list = MutableList<MutableList<Node>>(n+1) { MutableList<Node>(0) { Node(0,0)} }
    repeat(e) {
        val input = readLine().split(' ').toList().map { it.toInt() }
        list[input[0]].add(Node(input[1], input[2]))
        list[input[1]].add(Node(input[0], input[2]))
    }

    val input1 = readLine().split(' ').toList().map { it.toInt() }
    val v1 = input1[0]
    val v2 = input1[1]

    val arr1 = dikjstra(1, n)
    val arr2 = dikjstra(v1, n)
    val arr3 = dikjstra(v2, n)
//
//    println(arr1)
//    println(arr2)
//    println(arr3)

    val v1_cost = arr1[v1] +arr2[v2] + arr3[n]
    val v2_cost = arr1[v2] +arr3[v1] + arr2[n]

    val cost = Math.min(v1_cost, v2_cost)
    if (cost >= INF) {
        println(-1)
    } else {

        println(cost)
    }
}

fun dikjstra(start: Int, n: Int): MutableList<Int> {
    val dist = MutableList<Int>(n+1) { INF }
    dist[start] = 0
    val pq = PriorityQueue<Node>()
    pq.add(Node(start, 0))

    while (pq.isNotEmpty()) {
        val node = pq.poll()

        if (dist[node.nodeNum] < node.weight) continue

        list[node.nodeNum].forEach {
            if ( dist[it.nodeNum] > dist[node.nodeNum] + it.weight) {
                    dist[it.nodeNum] = dist[node.nodeNum] + it.weight
                    pq.add(Node(it.nodeNum, it.weight))
                }
            }
        }


    return dist
}
