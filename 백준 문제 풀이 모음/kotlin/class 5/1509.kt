
private lateinit var matrix : MutableList<MutableList<Int>>

fun main() = with(System.`in`.bufferedReader()){
    val str = readLine().toCharArray()
    val L = str.size
    matrix = MutableList<MutableList<Int>>(L) { MutableList<Int>(L) { 0 } }

    for (i in 0 until L) {
        matrix[i][i] = 1
    }

    for (i in 1 until L) {
        if (str[i].equals(str[i-1])) {
            matrix[i-1][i] = 1
        }
    }

    for (l in 3 until L+1) {
        for (start in 0 until L-l+1) {
            val end = start + l - 1
            if (str[start].equals(str[end]) && matrix[start+1][end-1] == 1) {
//                println("${start} ${end}")
                matrix[start][end] = 1
            }
        }
    }

    val dp = MutableList<Int>(L+1) { 2500 }
    dp[L] = 0
//    println(dp)
    for (end in 0 until L) {
//        println(dp)
        for ( start in 0 until end+1) {
            if (matrix[start][end] == 1 ) {
                if (start == 0) {
                    dp[end] = Math.min(dp[end], dp[L] + 1)
                } else {
                    dp[end] = Math.min(dp[end], dp[start - 1] + 1)
                }
            } else {
                dp[end] = Math.min(dp[end], dp[end-1] + 1)
            }
        }
    }
//    matrix.forEach {
//        println(it)
//    }

    println(dp[L-1])

}

