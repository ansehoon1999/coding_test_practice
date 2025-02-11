import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val dp = MutableList<MutableList<Int>>(21) {
        MutableList<Int>(21) { 0 }
    }

    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    for(i in 1 .. 20) {
        dp[i][0] = 1
        dp[i][i] = 1
        dp[i][1] = i
    }

    for(i in 2 .. 20) {
        for(j in 2 .. 20) {
            if(i >= j) {
                dp[i][j] = dp[i-1][j] + dp[i-1][j-1]
            }
        }
    }

//    dp.forEach {
//        println(it)
//    }

    println(dp[n][k])
}










