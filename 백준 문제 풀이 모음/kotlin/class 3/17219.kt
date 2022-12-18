

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine().split(' ').toList()
    val n = str[0].toInt()
    val m = str[1].toInt()
    val map = hashMapOf<String, String>()

    repeat(n) {
        val input = readLine().split(' ').toList()
        map[input[0]] = input[1]
    }

    val sb = StringBuilder()

    repeat(m) {
        val input = readLine().toString()
        sb.append(map[input])
        sb.append('\n')
    }

    println(sb.toString())
}
