import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     *
     */

    val n = br.readLine().toInt()
    val dp = MutableList<Long>(n + 1) { -1 }
    dp[0] = 0
    dp[1] = 1

    fun dfs(x: Int): Long {

        if (dp[x] != -1L) {
            return dp[x]
        }

        dp[x] = dfs(x-1) + dfs(x-2)
        return dp[x]
    }

    dfs(n)
    println(dp[n])
}














