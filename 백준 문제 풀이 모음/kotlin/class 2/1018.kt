import java.util.*


var min = 100000000

val bw = charArrayOf('B','W','B','W','B','W','B','W')
val wb = charArrayOf('W','B','W','B','W','B','W','B')

fun check(x : Int, y : Int, matrix : Array<CharArray>) : Int {

    var bw_count = 0
    var wb_count = 0

//    for (i in x until x + 8) {
//        for (j in y until y + 8) {
//            print(matrix[i][j])
//            print(' ')
//        }
//        println()
//    }

    for (i in x until x + 8) {
        for (j in y until y+8) {
            if (i % 2 == 0) {
                if (!matrix[i][j].equals(bw[j-y])) {
                    bw_count ++
                }

                if (!matrix[i][j].equals(wb[j-y])) {
                    wb_count ++
                }
            } else {
                if (!matrix[i][j].equals(wb[j-y])) {
                    bw_count ++
                }

                if (!matrix[i][j].equals(bw[j-y])) {
                    wb_count ++
                }
            }
        }
    }

//    println(wb_count)
//    println(bw_count)
    return Math.min(wb_count, bw_count)

}


fun main()= with(System.`in`.bufferedReader()) {
    val str = readLine().split(' ').toList()
    val n = str[0].toInt()
    val m = str[1].toInt()
    val matrix = Array(n) { CharArray(m) {'0'} }


    for (i in 0 until n) {
        val input = readLine().toCharArray()
        for ( j in 0 until m) {
            matrix[i][j] = input[j]
        }
    }

    for (i in 0 .. n-8) {
        for (j in 0 .. m-8) {

            min = Math.min(min, check(i, j, matrix))
        }
    }

    println(min)
//    val sb = StringBuilder()
//    matrix.forEach {
//        it.forEach {
//            sb.append(it)
//            sb.append(' ')
//        }
//        sb.append('\n')
//    }
//
//    println(sb.toString())


}
