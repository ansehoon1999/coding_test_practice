
private lateinit var dp : MutableList<MutableList<MutableList<Int>>>

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    dp = MutableList<MutableList<MutableList<Int>>>(n+1) { MutableList<MutableList<Int>>(10) { MutableList<Int>(1024) { 0 } } }


    for (k in 1 until 10) {
        dp[1][k][1 shl k] = 1
//        println(1 shl k)
    }

    var next_bit = -1
    for (length in 0 until n) {
        for (last in 0 until 10) {
            for (bit in 0 until 1024) {
                if ( last < 9) {
                    next_bit = bit or (1 shl (last+1))
//                    println("${bit} ${1 shl (last+1)} ${next_bit}")
                    dp[(length+1)][last+1][next_bit] += dp[length][last][bit]
                    dp[(length+1)][last+1][next_bit] %= 1000000000
                }
                if ( last > 0) {
                    next_bit = bit or (1 shl (last-1))
                    dp[(length+1)][last-1][next_bit] += dp[length][last][bit]
                    dp[(length+1)][last-1][next_bit] %= 1000000000
                }
            }
        }
    }

    var sum = 0

    for (i in 0 until 10) {
        sum += dp[n][i][1023]
        sum %= 1000000000
    }
    println(sum)
}
