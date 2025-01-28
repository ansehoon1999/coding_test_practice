import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val N = br.readLine().toInt()

    val dp = MutableList<LongArray>(151) {
        LongArray(10) { 0 }
    }

    repeat(10) {
        if (it != 0) dp[0][it] = 1
    }

    for (i in 1..101) {

        repeat(10) { j ->

            if (j == 0) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % 1000000000
            } else if (j == 9) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % 1000000000
            } else {
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % 1000000000
                dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % 1000000000
            }
        }
    }

//    dp.forEach {
//        println(it.toList())
//    }

    var sum = 0L
    repeat(10) {
        sum = (sum + dp[N-1][it]) % 1000000000
    }

    println(sum)

    writer.flush()
    writer.close()

}
