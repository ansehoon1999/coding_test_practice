import java.util.*

class Solution {
    private lateinit var graph: MutableList<MutableList<Node>>

    fun solution(n: Int, paths: Array<IntArray>, gates: IntArray, summits: IntArray): IntArray {

        graph = mutableListOf()

        for(i in 0 until n+1) {
            graph.add(mutableListOf())
        }

        paths.forEach {
            val start = it[0]
            val end = it[1]
            val weight = it[2]

            if(isGate(start, gates) || isSummit(end, summits)) {
                graph[start].add(Node(end, weight))
            } else if(isGate(end, gates) || isSummit(start, summits)) {
                graph[end].add(Node(start, weight))
            } else {
                graph[start].add(Node(end, weight))
                graph[end].add(Node(start, weight))
            }
        }

        return dijkstra(n, gates, summits)
    }

    fun dijkstra(n: Int, gates: IntArray, summits: IntArray): IntArray {
        val queue: Queue<Node> = LinkedList<Node>()
        val intensity = IntArray(n+1)

        Arrays.fill(intensity, Integer.MAX_VALUE)

        gates.forEach {
            queue.add(Node(it, 0))
            intensity[it] = 0
        }

        while(queue.isNotEmpty()) {
            val cn = queue.poll()

            if(cn.weight > intensity[cn.end]) {
                continue
            }

            for(i in 0 until graph[cn.end].size) {
                val nn = graph[cn.end][i]

                val dis = maxOf(intensity[cn.end], nn.weight)
                if(intensity[nn.end] > dis) {
                    intensity[nn.end] = dis
                    queue.add(Node(nn.end, dis))
                }
            }
        }

        var mn = Integer.MAX_VALUE
        var mw = Integer.MAX_VALUE

        Arrays.sort(summits)

        summits.forEach { summit ->
            if(intensity[summit] < mw) {
                mn = summit
                mw = intensity[summit]
            }
        }

        return intArrayOf(mn, mw)
    }

    data class Node(
            val end: Int,
            val weight: Int
    )

    fun isGate(start: Int, gates: IntArray): Boolean {
        return gates.contains(start)
    }

    fun isSummit(end: Int, summits: IntArray): Boolean {
        return summits.contains(end)
    }

}