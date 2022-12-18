

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    val input = readLine().split(' ').toList().map { it.toInt() }
    val new = input.distinct().sorted()

    val map = hashMapOf<Int, Int>()

    var idx = 0
    new.forEach {
        map[it] = idx ++
    }

    val sb = StringBuilder()
    input.forEach {
        sb.append(map[it])
        sb.append(' ')
    }

    println(sb.toString())

}