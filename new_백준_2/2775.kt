import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     * dp[i][j] = 거주자 수
     */

    val t = br.readLine().toInt()

    val dp = MutableList<MutableList<Int>>(16) {
        MutableList<Int>(16) { 0 }
    }

    for(i in 1 .. 15) {
        dp[0][i] = i
    }

    for(i in 1 .. 15) {
        for(j in 1 .. 15) {
            dp[i][j] = dp[i][j-1] + dp[i-1][j]
        }
    }

//    dp.forEach {
//        println(it)
//    }

    repeat(t) {
        val k = br.readLine().toInt()
        val n = br.readLine().toInt()

        println(dp[k][n])
    }
}














