import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Collections
import java.util.PriorityQueue
import kotlin.math.abs

data class Node(
    val to: Int,
    val cost: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     *  1 2 3
     *
     */

    val n = br.readLine().toInt()

    val dp = MutableList<Long>(1000002) { 0L }
    dp[0] = 0
    dp[1] = 0
    dp[2] = 1
    for(i in 3 .. n) {
       dp[i] = ((i-1) * (dp[i-1] + dp[i-2] % 1000000000) % 1000000000)
    }
    println(dp[n])
}










