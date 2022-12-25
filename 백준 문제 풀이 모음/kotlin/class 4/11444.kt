


val DIV : Long = 1000000007

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toLong()

    var matrix = MutableList<MutableList<Long>>(2) { MutableList<Long>(2) { 0 } }
    matrix[0][0] = 1
    matrix[0][1] = 1
    matrix[1][0] = 1
    matrix[1][1] = 0

    val result = pow(n, matrix)


    println(result[1][0])
}

fun pow(n: Long, matrix: MutableList<MutableList<Long>>): MutableList<MutableList<Long>> {
    var matrix2 = MutableList<MutableList<Long>>(2) { MutableList<Long>(2) { 0 } }
    matrix2[0][0] = 1
    matrix2[0][1] = 1
    matrix2[1][0] = 1
    matrix2[1][1] = 0


    if (n == 1L) return matrix

    else {
//        matrix.forEach {
//            println(it)
//        }
//        println()
        val tmp = pow(n/2, matrix)
        val rel = mul(tmp, tmp)
        if (n % 2 == 0L) {
            return rel
        } else {
            return mul(rel, matrix2)
        }
    }
}

fun mul(matrix1: MutableList<MutableList<Long>>, matrix2: MutableList<MutableList<Long>>): MutableList<MutableList<Long>> {
    val result = MutableList<MutableList<Long>>(2) { MutableList<Long>(2) { 0 } }
    result[0][0] = ((matrix1[0][0] * matrix2[0][0]) + (matrix1[0][1] * matrix2[1][0])) % DIV
    result[0][1] = ((matrix1[0][0] * matrix2[0][1]) + (matrix1[0][1] * matrix2[1][1])) % DIV
    result[1][0] = ((matrix1[1][0] * matrix2[0][0]) + (matrix1[1][1] * matrix2[1][0])) % DIV
    result[1][1] = ((matrix1[1][0] * matrix2[0][1]) + (matrix1[1][1] * matrix2[1][1])) % DIV

    return result
}
