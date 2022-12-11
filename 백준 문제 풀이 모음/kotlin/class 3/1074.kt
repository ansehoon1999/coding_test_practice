package class3

var count = 0
var result = 0

fun main () = with(System.`in`.bufferedReader()) {
    val str = readLine().split(' ').toList()
    val n = str[0].toInt()
    val r = str[1].toInt()
    val c = str[2].toInt()

    divide(1 shl(n), 0, 0, r, c)

    println(result)
}

fun divide(size: Int, row: Int, col: Int, r: Int, c: Int) {
    if (r !in row until row + size || c !in col until col + size) {
        count += (size * size)
        return
    }

    if (r == row && c == col) {
        result = count
        return
    }

    divide(size/2, row, col, r, c)
    divide(size/2, row, col + size/2, r, c)
    divide(size/2, row + size/2, col, r, c)
    divide(size/2, row + size/2, col + size/2, r, c)






}
