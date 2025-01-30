import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.time.Duration.Companion.seconds

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()
    val dp = MutableList<MutableList<Long>>(501) {
        MutableList<Long>(501) { 0L }
    }
    val arr = mutableListOf<Pair<Int, Int>>()

    repeat(n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        arr.add(Pair(a, b))
    }

    for(len in 1 until n) {
        for(start in 0 until n - len) {
            val end = start + len
            dp[start][end] = Long.MAX_VALUE

            for(mid in start until end) {
                val cost = dp[start][mid] + dp[mid+1][end] + arr[start].first * arr[mid].second  * arr[end].second
                if(dp[start][end] > cost) {
                    dp[start][end] = cost
                }
            }
        }
    }



    writer.flush()
    writer.close()

}
