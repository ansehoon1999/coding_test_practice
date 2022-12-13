package class3

fun main () = with(System.`in`.bufferedReader()) {
    val map = hashMapOf<String, Boolean>()
    val str = readLine().split(' ').toList()
    val n = str[0].toInt()
    val m = str[1].toInt()

    repeat(n) {
        val input = readLine().toString()
        map[input] = true
    }

    val result = mutableListOf<String>()
    repeat(m) {
        val input = readLine().toString()
        try {
            if (map[input] == true) {
                result.add(input)
            }
        } catch (e : Exception) {

        }
    }

    result.sort()
    val sb = StringBuilder()
    sb.append(result.size)
    sb.append('\n')
    result.forEach {
        sb.append(it)
        sb.append('\n')
    }

    println(sb.toString())


}