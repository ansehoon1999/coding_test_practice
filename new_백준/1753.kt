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

    var st = StringTokenizer(br.readLine())
    val v = st.nextToken().toInt()
    val e = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val start = st.nextToken().toInt()

    val hashMap = HashMap<Int, MutableList<Node>>()
    val visited = BooleanArray(v + 1)
    val distance = IntArray(v + 1) { Integer.MAX_VALUE }

    repeat(v) {
        hashMap[it + 1] = mutableListOf()
    }

    repeat(e) {
        val (u, v, w) = br.readLine().split(" ").map { it.toInt() }
        hashMap[u]?.add(Node(v, w))
    }


    val pq = PriorityQueue<Node>({ a, b ->
        a.weight - b.weight
    })

    pq.add(Node(start, 0))
    distance[start] = 0

    while(pq.isNotEmpty()) {
        val cur = pq.poll()!!
        val curV = cur.num
        val curW = cur.weight

        if(visited[curV]) {
            continue
        }

        visited[curV] = true

        hashMap[curV]?.forEach { next ->
            val nextV = next.num
            val nextW = next.weight

            if(distance[nextV] > distance[curV] + nextW) {
                distance[nextV] = distance[curV] + nextW
                pq.add(Node(nextV, distance[nextV]))
            }

        }

    }

    for(idx in 1 until visited.size) {
        if(visited[idx]) {
           println(distance[idx])
        } else {
            println("INF")
        }
    }

    bw.flush()
    bw.close()
}

