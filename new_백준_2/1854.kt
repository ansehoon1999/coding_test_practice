import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Collections
import java.util.PriorityQueue

data class Node(
    val to: Int,
    val cost: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()


    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }

    val graph = hashMapOf<Int, MutableList<Node>>()

    repeat(m) {
        graph[it + 1] = mutableListOf()
    }

    repeat(m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        graph[a]?.add(Node(b, c.toLong()))
    }

    val visited = MutableList<PriorityQueue<Long>>(n + 1) {
        PriorityQueue(Collections.reverseOrder())
    }

    val deque = ArrayDeque<Node>()
    deque.add(Node(1, 0))
    visited[1].add(0)

    while(deque.isNotEmpty()) {
        val cur = deque.removeFirst()

        graph[cur.to]?.forEach { next ->
            val cost = cur.cost + next.cost

            if(visited[next.to].size != k) {
                visited[next.to].add(cost)
                deque.add(Node(next.to, cost))
            } else if(visited[next.to].size == k) {

                if(cost < visited[next.to].peek()) {
                    visited[next.to].add(cost)
                    visited[next.to].poll()
                    deque.add(Node(next.to, cost))
                }

            }
        }
    }

    for(idx in 1 until visited.size) {
        if(visited[idx].size != k) {
            writer.write("${-1}\n")
        }else{
            writer.write("${visited[idx].poll()}\n")
        }
    }


    writer.flush()
    writer.close()
}

