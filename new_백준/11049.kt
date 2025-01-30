import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val INF = Integer.MAX_VALUE / 2
    val n = br.readLine().toInt()

    val graph = mutableListOf<MutableList<Int>>()

    repeat(n) {
        val tmp = br.readLine().split(" ").map { it.toInt() }.toMutableList()
        graph.add(tmp)
    }

    val dp = MutableList<MutableList<Int>>(16) {
        MutableList<Int>(1 shl 16) { -1 }
    }


    fun dfs(node: Int, state: Int): Int {

        if (state == ((1 shl n) - 1)) {
            if (graph[node][0] != 0) {
                return graph[node][0]
            } else {
                return INF
            }
        }

        if (dp[node][state] != -1) return dp[node][state]

        dp[node][state] = INF
        for (i in 0 until n) {
            if (state and (1 shl i) != 0 || graph[node][i] == 0) {
                continue
            }

            dp[node][state] = minOf(dp[node][state], graph[node][i] + dfs(i, state or (1 shl i)))

        }
        return dp[node][state]
    }

    println(dfs(0, 1))

    writer.flush()
    writer.close()


}