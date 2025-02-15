import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     * dp[idx][0] = dp[idx-1][0] + dp[idx-1][1]
     * dp[idx][1] = dp[idx-1][0] + 1
     */

    val n = br.readLine().toInt()

    val dp = MutableList<MutableList<Long>>(n+1) {
        MutableList<Long>(2) { 0L }
    }
    dp[1][0] = 0
    dp[1][1] = 1

    for(idx in 2 .. n) {
        dp[idx][0] = dp[idx-1][0] + dp[idx-1][1]
        dp[idx][1] =  dp[idx-1][0]
    }

    println(dp[n][0] + dp[n][1])

}














