import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     *
     */

    val n = br.readLine().toInt()
    val m =br.readLine().toInt()

    val dp = MutableList<MutableList<Long>>(n + 1) {
        MutableList<Long>(n+1) { Long.MAX_VALUE / 2 }
    }

    repeat(m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        dp[a][b] = minOf(dp[a][b], c.toLong())
    }



    for(k in 1 until n + 1) {
        for(i in 1 until n+1) {
            for(j in 1 until n+1) {
                if(i == j) {
                    dp[i][j] = 0
                    continue
                }
                dp[i][j] = minOf(dp[i][j], dp[i][k] + dp[k][j])
            }
        }
    }

    for(i in 1 .. n) {
        for(j in 1 .. n) {
            print("${if(dp[i][j] == Long.MAX_VALUE / 2) 0 else dp[i][j]} ")
        }
        println()
    }

}














