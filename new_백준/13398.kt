import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val N = br.readLine().toInt()

    val numList = br.readLine().split(" ").map { it.toLong() }.toMutableList()

    val dp = MutableList<LongArray>(N + 10) { LongArray(2) { Long.MIN_VALUE} }

    dp[0][0] = numList[0].toLong() // 연속된 합
    dp[0][1] = numList[0].toLong() // 특정 수 제거 케이스

    var answer = numList[0]
    for(i in 1 until N) {
        dp[i][0] = maxOf(dp[i-1][0] + numList[i], numList[i])

        dp[i][1] = maxOf(dp[i-1][0], dp[i-1][1] + numList[i])

        answer = maxOf(answer, maxOf(dp[i][0], dp[i][1]))
    }


    println(answer)


    // 이전의 값과 더하기

    // 이전의 것도 제거 되어서 연속적으로 제거 되는 것인지

    // 현재부터 제거 되는 것인지



    writer.flush()
    writer.close()

}
