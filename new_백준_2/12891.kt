import java.io.BufferedReader
import java.io.InputStreamReader

data class Node(
    val num: Int,
    var left: Node? = null,
    var right: Node? = null
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     *
     */

    val n = br.readLine().toInt()

    val dp = MutableList<Long>(1001) { 0 }
    dp[1] = 1
    dp[2] = 2

    for(i in 3 .. 1000) {
        dp[i] = (dp[i-1] + dp[i-2]) % 10007
    }

//    println(dp)

    println(dp[n])

    writer.flush()
    writer.close()
}















