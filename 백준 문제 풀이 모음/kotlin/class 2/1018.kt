import java.util.*

val bw = charArrayOf('B','W','B','W','B','W','B','W')
val wb = charArrayOf('W','B','W','B','W','B','W','B')
var matrix : Array<CharArray> = arrayOf()
var nm: List<Int> = listOf()

fun check(x: Int, y: Int): Int {

    var cntW = 0
    var cntB = 0

    for (i in x until x + 8) {

        when(i%2) {
            0 -> {
                for (j in y until y + 8) {
                    if (bw[j - y] != matrix[i][j])
                        cntB++
                    if (wb[j - y] != matrix[i][j])
                        cntW++
                }
            }
            1 -> {
                for (j in y until y + 8) {
                    if (bw[j - y] != matrix[i][j])
                        cntW++
                    if (wb[j - y] != matrix[i][j])
                        cntB++
                }
            }
        }
    }

    return Math.min(cntW, cntB)

}
fun main()= with(System.`in`.bufferedReader()) {


    val str = StringTokenizer(readLine())
    val row = str.nextToken().toInt()
    val col = str.nextToken().toInt()

    matrix = Array(row) { IntArray(col) }
        .map { readLine().toCharArray() }
        .toTypedArray()

    for (i in 0 until 8) {
        for ( j in 0 until 8) {
            print(matrix[i][j])
        }
        println()
    }

    var low = row * col

    for (i in 0 until row - 7) {
        for ( j in 0 until col - 7 ) {
            low = Math.min(low, check(i, j))
        }
    }


    println(low)
}

//import java.io.BufferedReader
//import java.io.InputStreamReader
//
//var nm: List<Int> = listOf()
//var matrix: Array<CharArray> = arrayOf()
//val bw = charArrayOf('B','W','B','W','B','W','B','W')
//val wb = charArrayOf('W','B','W','B','W','B','W','B')
//
//fun check(x: Int, y: Int): Int {
//
//    var cntW = 0
//    var cntB = 0
//
//    for (i in x until x + 8) {
//
//        when(i%2) {
//            0 -> {
//                for (j in y until y + 8) {
//                    if (bw[j - y] != matrix[i][j])
//                        cntB++
//                    if (wb[j - y] != matrix[i][j])
//                        cntW++
//                }
//            }
//            1 -> {
//                for (j in y until y + 8) {
//                    if (bw[j - y] != matrix[i][j])
//                        cntW++
//                    if (wb[j - y] != matrix[i][j])
//                        cntB++
//                }
//            }
//        }
//    }
//
//    return Math.min(cntW, cntB)
//
//}
//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//
//    nm = readLine()
//        .split(" ")
//        .map { it.toInt() }
//    matrix = Array(nm[0]) { IntArray(nm[1]) }
//        .map { readLine().toCharArray() }
//        .toTypedArray()
//
//    for (i in 0 until 8) {
//        for ( j in 0 until 8) {
//            print(matrix[i][j])
//        }
//        println()
//    }
//
//    var xShift = 0
//    var yShift = 0
//    var min = nm[0] * nm[1]
//
//    while (true) {
//        if (yShift + 8 > nm[1]) break
//
//        min = Math.min(min, check(xShift, yShift))
//
//        if (xShift + 8 < nm[0]) xShift++
//        else {
//            xShift = 0
//            yShift++
//        }
//    }
//
//    println(min)
//
//}