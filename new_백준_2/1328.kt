import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()


    /**
     * i = 건물의 개수
     * j = 왼쪽에서 보이는 개수
     * k = 오른쪽에서 보이는 개수
     * s[i][j][k]
     */

    val (n, l, r) = br.readLine().split(" ").map { it.toInt() }

    val dp = MutableList<MutableList<MutableList<Long>>>(101) {
        MutableList<MutableList<Long>>(101) {
            MutableList<Long>(101) { 0L }
        }
    }

    val MOD = 1000000007
    dp[1][1][1] = 1
    dp[2][2][1] = 1
    dp[2][1][2] = 1

    for(i in 2 .. n) {
        for(j in 1 .. n) {
            for(k in 1 .. n) {
                dp[i][j][k] = (dp[i-1][j-1][k] + dp[i-1][j][k-1] + dp[i-1][j][k] * (i-2)) % MOD
            }
        }
    }

    println(dp[n][l][r])




    writer.flush()
    writer.close()
}


