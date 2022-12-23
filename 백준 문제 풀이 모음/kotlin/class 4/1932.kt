
private lateinit var matrix : MutableList<MutableList<Int>>

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    matrix = MutableList<MutableList<Int>>(n+1) { MutableList<Int> (0) { 0 } }

    for (i in 1 .. n) {
        val input = readLine().split(' ').toList().map { it.toInt() }
        matrix[i] = input.toMutableList()
    }

//    matrix.forEach {
//        println(it)
//    }
//

    for (i in 2 until n+1) {
        val arr_size = matrix[i].size
//        println(arr_size)
        for (j in 0 until arr_size) {
            if (j == 0) {
                matrix[i][j] += matrix[i-1][j]
            } else if (j == arr_size -1) {
                matrix[i][j] += matrix[i-1][j-1]
            } else {
                matrix[i][j] += Math.max(matrix[i-1][j-1], matrix[i-1][j])
            }
        }

    }
    print(matrix[n].max())

//
//    matrix.forEach {
//        println(it)
//    }

}

