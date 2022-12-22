

fun main() = with(System.`in`.bufferedReader()){
    val (n, m) = readLine().split(' ').toList().map { it.toInt() }

    val matrix = MutableList<MutableList<Int>>(n+1){ MutableList<Int>(n+1) { 0 } }

    for (i in 0 until n) {
        val input = readLine().split(' ').toList().map { it.toInt() }
        for (j in 0 until n) {
            matrix[i+1][j+1] = input[j]
        }
    }

    for (i in 1 .. n) {
        for (j in 0 until n) {
            matrix[i][j+1] += matrix[i][j]
        }
    }



    for(j in 1 .. n) {
        for (i in 0 until n) {
            matrix[i+1][j] += matrix[i][j]
        }
    }


    val sb = StringBuilder()
    repeat(m) {
        val (x1, y1, x2, y2) = readLine().split(' ').toList().map { it.toInt() }
        val cost = matrix[x2][y2] - matrix[x1-1][y2] - matrix[x2][y1-1] + matrix[x1-1][y1-1]

        sb.append(cost)
        sb.append('\n')
    }
    println(sb.toString())
}
