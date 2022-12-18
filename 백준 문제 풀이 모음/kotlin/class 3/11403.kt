
var matrix = MutableList<MutableList<Int>>(0) { MutableList(0) { 0 } }

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    matrix = MutableList<MutableList<Int>>(n) { MutableList(n) { 0 } }

    for (i in 0 until n) {
        val input = readLine().split(' ').toList()
        for (j in 0 until n) {
            matrix[i][j] = input[j].toInt()
        }
    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (matrix[i][k] == 1 && matrix[k][j] == 1 ) {
                    matrix[i][j] = 1
                }
            }
        }
    }

    val sb = StringBuilder()
    matrix.forEach {
        it.forEach {
            sb.append(it)
            sb.append(' ')
        }
        sb.append('\n')
    }
    println(sb.toString())


}