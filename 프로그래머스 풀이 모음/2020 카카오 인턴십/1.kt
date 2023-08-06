//private lateinit var matrix: Array<IntArray>
//
//    val rows = 100
//    val columns = 97
//    val queries = arrayOf(
//            intArrayOf(1,1,100,97),
//
//    )
//
//    println(solution(rows, columns, queries).toMutableList())
//fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
//
//    matrix = Array(rows) {
//        IntArray(columns) { 0 }
//    }
//
//    var answer = mutableListOf<Int>()
//
//    var num = 1
//    for (i in 0 until rows) {
//        for (j in 0 until columns) {
//            matrix[i][j] = num
//            num++
//        }
//    }
//
//
////    println(matrix)
//
//    queries.forEach { query ->
//
//        val (x1, y1, x2, y2) = query
//
//        rotation(x1, y1, x2, y2)
//
//        var min = 100000000
//        for(x in x1-1 .. x2-1) {
//            min = minOf(min, matrix[x][y1-1])
//            min = minOf(min, matrix[x][y2-1])
//        }
//
//        for(y in y1-1 .. y2-1) {
//            min = minOf(min, matrix[x1-1][y])
//            min = minOf(min, matrix[x2-1][y])
//        }
//
//        answer.add(min)
//    }
//
//
//    return answer.toIntArray()
//}
//
//fun rotation(x1: Int, y1: Int, x2: Int, y2: Int) {
//
//    val topRight = matrix[x1-1][y2-1]
//    for(y in y2 - 2 downTo y1 - 1  ) {
//        matrix[x1-1][y+1] = matrix[x1-1][y]
//    }
//
////    val bottomRight = matrix[x2-1][y2-1]
//
//    for(x in x1-1 .. x2-2) {
//        matrix[x][y1-1] = matrix[x+1][y1-1]
//    }
//
//    for(y in y1-1 .. y2-2) {
//        matrix[x2-1][y] = matrix[x2-1][y+1]
//    }
//
//    for(x in x2-2 downTo x1-1) {
//        matrix[x+1][y2-1] = matrix[x][y2-1]
//    }
//
//
//    matrix[x1][y2-1] = topRight
////    matrix.forEach {
////        println(it)
////    }
//
//}


//import kotlin.math.ln
//
//fun main(args: Array<String>) {
//
//    val numbers = longArrayOf(
//             432
//    )
//
//    println(solution(numbers).toMutableList())
//}
//
//var result = 1
//
//fun log2(n: Int): Double {
//    return ln(n.toDouble()) / ln(2.0)
//}
//
//fun solution(numbers: LongArray): IntArray {
//    var answer = mutableListOf<Int>()
//
//    var binary = ""
//    numbers.forEach { num ->
//        result = 1
//        binary = java.lang.Long.toBinaryString(num)
//
//        println(binary.length)
//
//        val newLength = Math.pow((2).toDouble(), (log2(binary.length).toInt() + 1).toDouble()) - 1
//
//        println(newLength)
//
//        repeat(newLength.toInt() - binary.length) {
//            binary = "0$binary"
//        }
//        println("start: " + binary)
//
//        divider(binary)
//        answer.add(result)
//    }
//
//
//
//    return answer.toIntArray()
//}
//
//
//fun divider(binary: String) {
//    if(binary.length == 1) {
//        return
//    }
//
//    val mid = binary.length / 2
//    println(binary[mid])
//    if(binary[mid] == '0') {
//        if(binary.substring(0, mid).contains('1') || binary.substring(mid+1, binary.length).contains('1')) {
//            result = 0
//
//        } else {
//            result = 1
//
//        }
//        return
//    }
//
//    val front = binary.substring(0, mid)
//    val behind = binary.substring(mid+1, binary.length)
//    println(front)
//    println(behind)
//
//    divider(front)
//    divider(behind)
//
//}
//