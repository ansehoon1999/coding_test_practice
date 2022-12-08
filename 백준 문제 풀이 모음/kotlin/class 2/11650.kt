import java.util.StringTokenizer

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val arr = Array<Pair<Int, Int>>(n) { Pair(0,0) }
    for (i in 0 until n) {
        val input = StringTokenizer(readLine())

        val x = input.nextToken().toInt()
        val y = input.nextToken().toInt()

        arr.set(i, Pair(x, y))
    }

    arr.sortBy {
        it.first
    }

    arr.sortBy {
        it.second
    }

    val sb = StringBuilder()
    arr.forEach {
        sb.append(it.first.toString() + " " + it.second.toString())
        sb.append('\n')
    }

    println(sb.toString())

}