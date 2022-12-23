


data class Node (var nodeNum : Int, var weight : Int)

private lateinit var graph : MutableList<MutableList<Node>>
private lateinit var visited : MutableList<Boolean>

private var result1 = 0
private var node1 = -1

private var result2 = 0
private var node2 = -1

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    graph = MutableList<MutableList<Node>>(n+1) { MutableList<Node>(0) { Node(0,0)} }
    visited = MutableList<Boolean>(n+1) { false }

    repeat(n-1) {

        val (a, b, c) = readLine().split(' ').toList().map { it.toInt() }

        graph[a].add(Node(b, c))
        graph[b].add(Node(a, c))

    }

    visited[1] = true
    dfs1(1, 0)

    visited = MutableList<Boolean>(n+1) { false }
    visited[node1] = true
    dfs1(node1, 0)


    print(Math.max(result1, result2))


}

fun dfs1(start: Int, count : Int) {

    var count = count

    if (count >= result1) {
        result1 = count
        node1 = start
    }

    graph[start].forEach {
        if (!visited[it.nodeNum]) {
            visited[it.nodeNum] = true
            count = count + it.weight
            dfs1(it.nodeNum, count)
            count = count - it.weight
        }
    }


}

fun dfs2(start: Int, count : Int) {

    var count = count

    if (count >= result2) {
        result2 = count
        node2 = start
    }

    graph[start].forEach {
        if (!visited[it.nodeNum]) {
            visited[it.nodeNum] = true
            count = count + it.weight
            dfs2(it.nodeNum, count)
            count = count - it.weight
        }
    }


}
