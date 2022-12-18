
fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    val list = MutableList<Int>(1001) { 0 }
        list[1] = 1
        list[2] = 3

    for (i in 3..n) {
        list[i] = (list[i - 1] + 2* list[i - 2]) % 10007
    }

    println(list[n])

}
//
//import java.util.*
//
//
//fun main(args: Array<String>) {
//    val sc = Scanner(System.`in`)
//    val n = sc.nextInt()
//    val dp = IntArray(1001)
//    dp[1] = 1
//    dp[2] = 3
//    for (i in 3..n) {
//        dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007
//    }
//    println(dp[n])
//}