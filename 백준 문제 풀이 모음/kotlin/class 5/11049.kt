

private lateinit var dp : MutableList<MutableList<Long>>

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    dp = MutableList<MutableList<Long>>(n) { MutableList<Long>(n) { 0L } }
    val matrix = mutableListOf<Pair<Long, Long>>()

    repeat(n) {
        val input = readLine().split(' ').map { it.toLong() }
        matrix.add(Pair(input[0], input[1]))
    }

    

    for (i in 1 until n) {
        for (j in 0 until n - i) {
            if (i == 1) {
                dp[j][j+i] = (matrix[j].first *matrix[j].second * matrix[j+i].second)
                continue
            }

            dp[j][j+i] = Long.MAX_VALUE
            for (k in j until j+i) {
                dp[j][j+i] = Math.min(dp[j][j+i], dp[j][k] + dp[k+1][j+i] + (matrix[j].first * matrix[k].second * matrix[j+i].second))
            }
        }
    }

    println(dp[0][n-1])

}