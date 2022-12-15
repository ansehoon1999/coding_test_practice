
var matrix = MutableList(0)  { MutableList<Int>(0) { 0 } }
var white = 0
var black = 0
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    matrix = MutableList(n)  { MutableList<Int>(n) { 0 } }
    for ( i in 0 until n) {
        val input = readLine().split(' ').toList()
        for (j in 0 until n) {
            matrix[i][j] = input[j].toInt()
        }
    }

    divide(n, 0, 0)

    println(white)
    println(black)

}

fun divide(n: Int, rol: Int, col: Int) {

    val first = matrix[rol][col]
    var state = true
    for (i in rol until rol + n) {
        for (j in col until col + n) {
            if (matrix[i][j] != first) {
                state = false
            }
        }
    }

    if (!state) {
        val size = n / 2
        divide(size, rol, col)
        divide(size, rol + size, col)
        divide(size, rol, col + size)
        divide(size, rol + size, col + size)
    } else {
        if (first == 0) {
            white++
        } else {
            black++
        }
    }
}

