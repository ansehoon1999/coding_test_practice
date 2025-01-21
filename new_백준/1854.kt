import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.PriorityQueue
import java.util.StringTokenizer

lateinit var parent: MutableList<Int>

data class Node(
    val num: Int,
    val weight: Int,
)

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

//    var st = StringTokenizer(br.readLine())

    val hashMap = hashMapOf<Int, MutableList<Node>>()

    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }

    repeat(n) {
        hashMap[it+1] = mutableListOf()
    }

    repeat(m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        hashMap[a]?.add(Node(b, c))
    }

    val distanceList = MutableList<MutableList<Int>>(n+1) {
        MutableList<Int>(k) { Integer.MAX_VALUE }
    }

    val pq = PriorityQueue<Node>({ a, b -> a.weight - b.weight})
    pq.add(Node(1, 0))
    distanceList[1][0] = 0

    while (pq.isNotEmpty()) {

        val cur = pq.poll()!!
        val curV = cur.num
        val curW = cur.weight

        hashMap[curV]?.forEach { next ->
            val nextV = next.num
            val nextW = next.weight

            val sCost = curW + nextW
            if(distanceList[nextV][k-1] > sCost) {
                distanceList[nextV][k-1] = sCost
                distanceList[nextV].sort()
                pq.add(Node(nextV, sCost))
            }
        }
    }



    for(idx in 1 until distanceList.size) {
        if(distanceList[idx][k-1] == Integer.MAX_VALUE) {
            println(-1)
        } else {
            println(distanceList[idx][k-1])
        }
    }


    bw.flush()
    bw.close()
}

