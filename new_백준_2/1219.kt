import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

data class Edge(
    val from: Int,
    val to: Int,
    var cost: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     * 벨만 - 포드 알고리즘
     */

    val INF = Long.MIN_VALUE

    val (n, start, end, m) = br.readLine().split(" ").map { it.toInt() }

    val vec = Array(101) { mutableListOf<Pair<Int, Int>>() }
    val earn = IntArray(101)
    val dist = LongArray(101) { INF }
    val visited = BooleanArray(101)

    repeat(m) {
        val (from, to, cost) = br.readLine().split(" ").map { it.toInt() }
        vec[from].add(Pair(to, -cost))
    }

    val st = StringTokenizer(br.readLine())
    repeat(n) {
        earn[it] = st.nextToken().toInt()
    }

    fun dfs(now: Int) {
        visited[now] = true

        vec[now].forEach { next ->
            if(!visited[next.first]) {
                dfs(next.first)
            }
        }
    }

    dfs(start)

    if(!visited[end]) {
        println("gg")
        return
    }

    repeat(n) {
        vec[it] = vec[it].map { Pair(it.first, it.second + earn[it.first]) }.toMutableList()
    }

    dist[start] = earn[start].toLong()

    for(i in 1 .. (2 * n)) {
        for(j in 0 until n) {
            vec[j].forEach {
                val next = it.first
                val cost = it.second.toLong()

                if(dist[j] == Long.MAX_VALUE) {
                    dist[next] = Long.MAX_VALUE
                } else if(dist[j] != INF && dist[next] < dist[j] + cost) {
                    dist[next] = dist[j] + cost
                    if(i >= n) dist[next] = Long.MAX_VALUE
                }
            }
        }
    }

    println(if(dist[end] == Long.MAX_VALUE) "Gee" else dist[end])

    writer.flush()
    writer.close()
}
