import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val st = StringTokenizer(br.readLine())
    val N = st.nextToken().toInt()
    val L = st.nextToken().toInt()
    val R = st.nextToken().toInt()

    val dp = MutableList<MutableList<MutableList<Long>>>(101) {
        MutableList<MutableList<Long>>(101) {
            MutableList<Long>(101) { 0 }
        }
    }

    dp[1][1][1] = 1

    for(n in 2 .. N) {
        for(l in 1 .. L) {
            for(r in 1 .. R) {
                dp[n][l][r] = ((dp[n-1][l-1][r] % 1000000007) + (dp[n-1][l][r-1] % 1000000007) + (dp[n-1][l][r] * (n - 2)  % 1000000007) ) % 1000000007
            }
        }
    }

    println(dp[N][L][R])





    writer.flush()
    writer.close()

}
