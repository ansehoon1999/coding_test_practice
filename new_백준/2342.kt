import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val list = br.readLine().split(" ").map { it.toInt() }

    val mp = mutableListOf<List<Int>>(
        listOf(0, 2, 2, 2, 2),
        listOf(2, 1, 3, 4, 3),
        listOf(2, 3, 1, 3, 4),
        listOf(2, 4, 3, 1, 3),
        listOf(2, 3, 4, 3, 1),
    )

    val dp = MutableList<MutableList<MutableList<Int>>>(list.size + 1) {
        MutableList<MutableList<Int>>(5) {
            MutableList<Int>(5) { Integer.MAX_VALUE / 2 }
        }
    }

    dp[0][0][0] = 0

    for(s in 1 .. list.size - 1) {
        val n = list[s-1]

        for(i in 0 until 5) {
            if(n == i) continue

            for(j in 0 until 5) {
                dp[s][i][n] = minOf(dp[s-1][i][j] + mp[j][n], dp[s][i][n])
            }
        }

        for(j in 0 until 5) {
            if(n == j) continue

            for(i in 0 until 5) {
                dp[s][n][j] = minOf(dp[s-1][i][j] + mp[i][n], dp[s][n][j])
            }
        }

    }

    var result = Integer.MAX_VALUE
    for(i in 0 until 5) {
        for(j in 0 until 5) {
            result = minOf(result, dp[list.size - 1][i][j])
        }
    }

   println(result)

    writer.flush()
    writer.close()

}
