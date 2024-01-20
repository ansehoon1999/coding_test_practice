import java.util.*

class Solution {

    val MAX = 1000001
    val hashMap = hashMapOf<Int, MutableList<Pair<Int, Int>>>()

    fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
        var answer: Int = Integer.MAX_VALUE


        repeat(n) { hashMap[it+1] = mutableListOf<Pair<Int, Int>>() }

        fares.forEach { fare ->

            val node1 = fare[0]
            val node2 = fare[1]
            val dist = fare[2]

            hashMap[node1]?.add(Pair(node2, dist))
            hashMap[node2]?.add(Pair(node1, dist))
        }

        // println(hashMap)

        // s -> point
        val sDist = dijkstra(s, n)

        val aDist = dijkstra(a, n)

        val bDist = dijkstra(b, n)

        // println("sDist: ${sDist}")
        // println("aDist: ${aDist}")
        // println("bDist: ${bDist}")

        for(cur in 1 .. n) {

            val interPoint = cur

            val sDistValue = sDist[interPoint]

            val aDistValue = aDist[interPoint]

            val bDistValue = bDist[interPoint]

            // println("${sDistValue}, ${aDistValue}, ${bDistValue}")
            answer = minOf(answer, sDistValue + aDistValue + bDistValue)
        }

        return answer
    }

    fun dijkstra(node: Int, nSize: Int): MutableList<Int> {

        val distance = MutableList<Int>(nSize + 1) { MAX }
        val pq = PriorityQueue<Pair<Int, Int>> { p1, p2 ->
            p1.second.compareTo(p2.second)
        }

        distance[node] = 0
        pq.add(Pair(node, 0))

        while(pq.isNotEmpty()) {
            val (curIdx, curCost) = pq.poll()

            if(distance[curIdx] < curCost) continue

            hashMap[curIdx]?.forEach { next ->
                val nextIdx = next.first
                val nextCost = curCost + next.second

                if(nextCost < distance[nextIdx]) {
                    distance[nextIdx] = nextCost
                    pq.add(Pair(nextIdx, nextCost))
                }
            }
        }

        return distance

    }
}