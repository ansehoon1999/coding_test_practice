import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val m = br.readLine().toInt()

    val list = br.readLine().split(" ").map { it.toInt() }

    val k = br.readLine().toInt()

    val dp = MutableList<MutableList<Long>>(51) {
        MutableList<Long>(51) { 0L }
    }

    for(i in 1 until 51) {
        dp[i][i] = 1
        dp[i][1] = i.toLong()
    }

    for(i in 2 until 51) {
        for(j in 2 until 51) {
            if(i >= j) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
            }
        }
    }

    var up = 0L
    list.forEach {
        if(it >= k) {
            up += dp[it][k]
        }
    }

//    dp.forEach {
//        println(it)
//    }


    var bottom = 1.0
    var bottomCnt = list.sum()
    var kCnt = k

    while(kCnt != 0) {

        bottom = bottom * bottomCnt
        bottomCnt -= 1

        bottom = bottom / kCnt

        kCnt --

//        println(bottom)
    }

//    println(up)


    println(up.toDouble() / bottom)

    writer.flush()
    writer.close()
}














