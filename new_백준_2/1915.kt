import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val dp = MutableList<MutableList<Int>>(n + 1) {
        MutableList<Int>(m + 1) {
            0
        }
    }

    repeat(n) { i ->
        val tmp = br.readLine().toList().map { it.toString().toInt() }

        tmp.forEachIndexed { index, _ ->
            dp[i + 1][index + 1] = tmp[index]
        }
    }

//    dp.forEach {
//        println(it)
//    }
//    println()

    for (i in 1..n) {
        for (j in 1..m) {
            if (dp[i - 1][j] == 0 || dp[i][j - 1] == 0 || dp[i - 1][j - 1] == 0) continue

            if(dp[i][j] == 0) continue

            dp[i][j] = minOf(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1

        }
    }


    var maxNum = 0L
    dp.forEach {
        it.forEach {
            maxNum = maxOf(it.toLong(), maxNum)
        }
    }
    println(maxNum * maxNum)

    writer.flush()
    writer.close()
}

