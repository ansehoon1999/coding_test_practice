import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val N = br.readLine().toInt()
    val T = MutableList<Int>(30) { 0 }
    val P = MutableList<Int>(30) { 0 }

    repeat(N) {
        val (t, p) = br.readLine().split(" ").map { it.toInt() }
        T[it + 1] = t
        P[it + 1] = p
    }

//    println(T)
//    println(P)
//    println()

    val dp = MutableList<Int>(30) { 0 }

    for(i in 1 .. N) {

        for(j in i .. i+T[i] - 2) {

            dp[j] = maxOf(dp[j], dp[i-1])
        }

        dp[i+T[i] - 1] = maxOf(dp[i+T[i] -1], dp[i-1] + P[i])

//        println(dp)

    }


    println(dp[N])
//    println(p)



    writer.flush()
    writer.close()

}
