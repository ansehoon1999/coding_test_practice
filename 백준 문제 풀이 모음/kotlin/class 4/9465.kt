



fun main() = with(System.`in`.bufferedReader()){
    val T = readLine().toInt()
    val sb = StringBuilder()

    repeat(T) {
        val n = readLine().toInt()
        val cost = MutableList<MutableList<Int>>(2) { MutableList<Int>(n+1) { 0 } }
        val dp = MutableList<MutableList<Int>>(2) { MutableList<Int>(n+1) { 0 } }

        for (i in 0 until 2) {
            val input = readLine().split(' ').map { it.toInt() }
            for (j in 1 .. n) {
                cost[i][j] = input[j-1]
            }
        }

//        println(dp)
//        println(cost)
        dp[0][1] = cost[0][1]
        dp[1][1] = cost[1][1]

        for (k in 2 .. n) {
            dp[0][k] = Math.max(dp[1][k-1], dp[1][k-2]) + cost[0][k]
            dp[1][k] = Math.max(dp[0][k-1], dp[0][k-2]) + cost[1][k]
        }

        sb.append(Math.max(dp[0][n], dp[1][n]))
        sb.append('\n')
    }

    print(sb)



}

