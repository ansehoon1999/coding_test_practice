import java.util.PriorityQueue

data class Node(var rol : Int, var col : Int, var count : Int)

private lateinit var matrix : MutableList<MutableList<Int>>

private val dr = listOf<Int>(1,-1,0,0)
private val dc = listOf<Int>(0,0,1,-1)
var count = 0
var n = -1
var m = -1

fun main() = with(System.`in`.bufferedReader()){
    val (rol1, col1) = readLine().split(' ').map { it.toInt() }
    n = rol1
    m = col1
    matrix = MutableList<MutableList<Int>>(n) { MutableList<Int>(m) { 0 }}

    for (i in 0 until n) {
        val input = readLine().toCharArray()
        for (j in 0 until m) {
            matrix[i][j] = Character.getNumericValue(input[j])
        }
    }


    println(bfs())
}

fun bfs() : Int {

    val visited = MutableList<MutableList<MutableList<Int>>>(n) { MutableList<MutableList<Int>>(m) { MutableList<Int>(2) { 0} } }


    visited[0][0][1] = 1
    val deque = ArrayDeque<Node>()
    deque.add(Node(0,0,1))

    while (deque.isNotEmpty()) {
        val node = deque.removeFirst()
        val a = node.rol
        val b = node.col
        val w = node.count

        if (a == n - 1 && b == m - 1) return visited[a][b][w]

        for (i in 0 until 4) {
            val x = a + dr[i]
            val y = b + dc[i]

            if ((0 <= x && x < n) && (0 <= y && y < m)) {
                if (matrix[x][y] == 1 && w == 1) {
                    visited[x][y][0] = visited[a][b][1] + 1
                    deque.add(Node(x, y, 0))
                }
                if (matrix[x][y] == 0 && visited[x][y][w] == 0) {
                    visited[x][y][w] = visited[a][b][w] + 1
                    deque.add(Node(x, y, w))
                }
            }
        }

//        println(visited)
        visited.forEach {
            it.forEach {
                print(it)
            }
            println()
        }
        println()
    }

    return -1
}
