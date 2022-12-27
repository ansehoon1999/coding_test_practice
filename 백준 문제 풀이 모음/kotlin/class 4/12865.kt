

fun main() = with(System.`in`.bufferedReader()){
    val (n, k) = readLine().split(' ').map { it.toInt() }

    val arr = MutableList<MutableList<Int>>(n+1) { MutableList<Int>(2) { 0 } }
    val dp = MutableList<MutableList<Int>>(n+1) { MutableList<Int>(k+1) { 0 } }

    for (i in 1..n) {
        val (w, v) = readLine().split(' ').map { it.toInt() }
        arr[i][0] = w
        arr[i][1] = v
    }

    for (i in 1..n){
        for (j in 1..k) { // weight
            val weight = arr[i][0]
            val value = arr[i][1]

            if (weight > j) dp[i][j] = dp[i-1][j]
            else {
                dp[i][j] = Math.max(value + dp[i-1][j-weight], dp[i-1][j])
                dp.forEach {
                    println(it)
                }
                println()
            }


        }
    }
    println(dp[n][k])

}

