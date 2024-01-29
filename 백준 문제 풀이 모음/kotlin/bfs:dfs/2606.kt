
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val node = br.readLine().toInt()

    val line = br.readLine().toInt()

    val graph = hashMapOf<Int, MutableList<Int>>()
    val visited = MutableList<Boolean>(node + 1) { false }

    repeat(node) {
        graph[it+1] = mutableListOf()
    }

    repeat(line) {

        val (node1, node2) = br.readLine().split(" ").map { it.toInt() }

        graph[node1]?.add(node2)
        graph[node2]?.add(node1)

    }

    val deque = ArrayDeque<Int>()
    deque.add(1)
    visited[1] = true
    var cnt = 0

    while(deque.isNotEmpty()) {
        val first = deque.removeFirst()

        graph[first]?.forEach {
            if(!visited[it]) {
                cnt ++
                visited[it] = true
                deque.add(it)
            }
        }

    }

    println(cnt)

}