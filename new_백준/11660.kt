fun main() {

    val (n, m) = readln().split(" ").map { it.toInt() }

    val matrix = MutableList<MutableList<Int>>(1) { MutableList<Int>( n+1) { 0 } }

    repeat(n) {
        val tmpList = listOf(0) + readln().split(" ").map { it.toInt() }
        matrix.add(tmpList.toMutableList())
    }

    for(row in 1 .. n) {
        for(col in 1 .. n) {
            matrix[row][col] += matrix[row - 1][col] + matrix[row][col-1] - matrix[row-1][col-1]
        }
    }

    repeat(m) {
        val (x1, y1, x2, y2) = readln().split(" ").map { it.toInt() }

        val result = matrix[x2][y2] - matrix[x2][y1-1] - matrix[x1-1][y2] + matrix[x1-1][y1-1]
        println(result)
    }
}