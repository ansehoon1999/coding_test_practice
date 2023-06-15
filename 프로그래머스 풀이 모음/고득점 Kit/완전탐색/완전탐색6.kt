import java.util.*
import kotlin.math.absoluteValue

class Solution {
    var answer = 100

    fun solution(n: Int, wires: Array<IntArray>): Int {

        val tree = Array(n + 1) {
            mutableListOf<Int>()
        }

        wires.forEach { wire ->
            val v1 = wire[0]
            val v2 = wire[1]

            tree[v1].add(v2)
            tree[v2].add(v1)
        }

        wires.forEach { wire ->
            val network1 = towerCount(wire[0], wire[1], tree, BooleanArray(n + 1))
            val network2 = towerCount(wire[1], wire[0], tree, BooleanArray(n + 1))

            answer = answer.coerceAtMost((network1 - network2).absoluteValue)
        }
        return answer
    }

    fun towerCount(v1: Int, v2: Int, tree: Array<MutableList<Int>>, visited: BooleanArray): Int {
        var count = 1
        val queue = ArrayDeque<Int>()
        visited[v1] = true
        queue.add(v1)

        while(queue.isNotEmpty()) {
            val current = queue.removeFirst()

            tree[current].forEach {  next ->
                if(!visited[next] && next != v2) {
                    count++
                    visited[next] = true
                    queue.add(next)
                }
            }
        }

        return count
    }
}