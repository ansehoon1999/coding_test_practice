

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    val matrix = MutableList<MutableList<Int>>(n) { MutableList<Int>(3) { 0 } }

    for (i in 0 until n) {
        val input = readLine().split(' ').toList()
        for (j in 0 until 3) {
            matrix[i][j] = input[j].toInt()
        }
    }

    for (i in 1 until n) {
        matrix[i][0] = Math.min(matrix[i][0] + matrix[i-1][1], matrix[i][0] + matrix[i-1][2])
        matrix[i][1] = Math.min(matrix[i][1] + matrix[i-1][0], matrix[i][1] + matrix[i-1][2])
        matrix[i][2] = Math.min(matrix[i][2] + matrix[i-1][0], matrix[i][2] + matrix[i-1][1])
    }

    println(matrix[n-1].min())


}
