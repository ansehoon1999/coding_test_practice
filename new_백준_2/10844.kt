import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     * i = 몇번 째 수
     * j =
     * dp[i][j] = 부분 수열 개수
     */

    val n = br.readLine().toInt()
    val dp = MutableList<MutableList<Long>>(102) {
        MutableList<Long>(10) { 0 }
    }

    val MOD = 1000000000L

    for(i in 1 .. 9) {
        dp[0][i] = 1
    }

    for(i in 1 until 101) {

        for(j in 0 .. 9) {
            if(j == 0) {
                dp[i][0] = (dp[i-1][1] % MOD)
                continue
            }

            if(j == 9) {
                dp[i][9] = (dp[i-1][8] % MOD)
                continue
            }

            dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % MOD
        }
    }

//    dp.forEach {
//        println(it)
//    }

    println(dp[n-1].sum() % MOD)
}














