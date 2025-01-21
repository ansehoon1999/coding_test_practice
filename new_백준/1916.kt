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
    val n = st.nextToken().toInt()
    st = StringTokenizer(br.readLine())
    val m = st.nextToken().toInt()

    val hashMap = hashMapOf<Int, MutableList<Node>>()

    repeat(n) {
        hashMap[it+1] = mutableListOf()
    }

    repeat(m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        hashMap[a]?.add(Node(b, c))
    }

    val (start, end) = br.readLine().split(" ").map { it.toInt() }


    val visited = BooleanArray(n+1)
    val distance = IntArray(n+1) { Integer.MAX_VALUE }

    val pq = PriorityQueue<Node>({ a, b ->
        a.weight - b.weight
    })
    pq.add(Node(start, 0))
    distance[start] = 0

    while(pq.isNotEmpty()) {
        val cur = pq.poll()!!
        val curV = cur.num
        val curW = cur.weight

        if(visited[curV]) continue

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

    println(distance[end])

    bw.flush()
    bw.close()
}

