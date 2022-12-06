import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val str = StringTokenizer(readLine())

    val a = str.nextToken().toInt()
    val b = str.nextToken().toInt()
    val v = str.nextToken().toInt()

    println(Math.ceil((v-a).toDouble() / (a-b).toDouble()).toInt() + 1)
}