import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val dp = Array<IntArray>(n+1) {
        IntArray(m+1)
    }

    repeat(n) { i ->
        val strList = br.readLine().map { it.toString().toInt() }
        for(j in 0 until strList.size) {
            dp[i+1][j+1] = strList[j]
        }
    }

    var maxCnt = 0
    for(i in 1 .. n) {
        for(j in 1 .. m) {

            if(dp[i][j] == 0) continue
            if(dp[i-1][j] == 0 || dp[i][j-1] == 0 || dp[i-1][j-1] == 0)  {
                continue
            }
            dp[i][j] = minOf(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
            maxCnt = maxOf(maxCnt, dp[i][j])
        }
    }


//    dp.forEach {
//        println(it.toList())
//    }
//    println()

    var sum = 0
    dp.forEach {
        it.forEach {
            sum = maxOf(sum, it)
        }
    }

    println(sum * sum)



    writer.flush()
    writer.close()

}
