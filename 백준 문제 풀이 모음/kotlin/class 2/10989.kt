
fun main () = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val arr = Array<Int>(10001) {0}
    repeat(n) {
        val input = readLine().toInt()

        arr[input] += 1
    }

    val sb = StringBuilder()

    for (i in 0 until 10001) {
        repeat(arr[i]) {
            sb.append(i)
            sb.append('\n')
        }
    }

    println(sb.toString())
}