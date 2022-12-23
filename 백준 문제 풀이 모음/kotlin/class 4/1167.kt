import java.util.StringTokenizer


data class Node (var nodeNum : Int, var weight : Int)

private lateinit var graph : MutableList<MutableList<Node>>
private lateinit var visited : MutableList<Boolean>

private var count = 0
private var node = -1
private var node2 = -1

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    graph = MutableList<MutableList<Node>>(n+1) { MutableList<Node>(0) { Node(0,0)} }
    visited = MutableList<Boolean> (n+1) { false }

    repeat(n) {
        val input = StringTokenizer(readLine())
        val start = input.nextToken().toInt()

        var i = 1
        while (true) {
            val node = input.nextToken().toInt()
            if (node == -1) {
                break
            } else {
                graph[start].add(Node(node, input.nextToken().toInt()))
                i++
            }
        }
    }

    var result = 0
    visited[1] = true
    dfs(1, result)

    var max1 = count
    var max1_node = node

//    println()
//    print(max1)
//    print(' ')
//    print(max1_node)


    count = 0

    var result2 = 0
    visited = MutableList<Boolean> (n+1) { false }
    visited[node] = true
    dfs(node, result2)

    var max2 = count
    var max2_node = node2

    print(Math.max(max1, max2))
//    println()
//    print(max2)
//    print(' ')
//    print(max2_node)

//    graph.forEach {
//        it.forEach {
//            print("Node(${it.nodeNum}, ${it.weight})")
//            print(' ')
//        }
//        println()
//    }


}

fun dfs(start: Int, result :Int) {

    var result = result
    if (result >= count) {
        count = result
        node = start

//        println("node: ${node}, count: ${count}")
    }
    count = Math.max(result, count)

    graph[start].forEach {

        if (!visited[it.nodeNum]) {
            visited[it.nodeNum] = true
            result += it.weight
            dfs(it.nodeNum, result)
            result -= it.weight
        }
    }


}
