import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

data class Node(
    val num: Int,
    val weight: Int
)

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val x = st.nextToken().toInt()

    val visited = MutableList<Boolean>(n + 1) { false }
    val hashMap = hashMapOf<Int, MutableList<Int>>()

    repeat(n) {
        hashMap[it] = mutableListOf()
    }

    repeat(m) {
        st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        hashMap[a]?.add(b)
    }


    val pq = ArrayDeque<Node>()
    pq.add(Node(x, 0))
    visited[x] = true

    val result = mutableListOf<Int>()

    while (pq.isNotEmpty()) {

        val first = pq.removeFirst()

        if (first.weight == k) {
            result.add(first.num)
            continue
        }

        hashMap[first.num]?.forEach { next ->
            if (!visited[next]) {
                visited[next] = true
                pq.add(Node(next, first.weight + 1))
            }
        }
    }

    if (result.isNotEmpty()) {

        result.sort()
        result.forEach {
            println(it)
        }
    } else {
        println(-1)
    }

}