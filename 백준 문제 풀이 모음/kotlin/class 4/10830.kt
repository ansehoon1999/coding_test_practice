import java.math.BigInteger

fun main() = with(System.`in`.bufferedReader()){
    val (n1, b1) = readLine().split(' ').toList().map { it.toLong() }
    val b = BigInteger.valueOf(b1.toLong())
    val n = n1.toInt()
    val matrix = MutableList<MutableList<Long>>(n) { MutableList<Long>(n) { 0 } }

    for (i in 0 until n) {
        val input = readLine().split(' ').toList().map { it.toLong() }.toTypedArray()
        for (j in 0 until n) {
            matrix[i][j] = input[j] % 1000
        }
    }

    val result = pow(n, b, matrix)

    val sb = StringBuilder()
    result.forEach {
        it.forEach {
            sb.append(it).append(' ')
        }
        sb.append('\n')
    }
    print(sb)
}

fun pow(n :Int, b: BigInteger, matrix : MutableList<MutableList<Long>>): MutableList<MutableList<Long>> {
    if (b == BigInteger.valueOf(1L)) return matrix

    else {
        val tmp = pow(n, BigInteger.valueOf((b/BigInteger.valueOf(2L)).toLong()), matrix)
        val rel = mul(n, tmp, tmp)
        if (b % BigInteger.valueOf(2L) == BigInteger.valueOf(0L)) {
            return rel
        } else {
            return mul(n, rel, matrix)
        }
    }
}

fun mul(n: Int, matrix1: MutableList<MutableList<Long>>, matrix2: MutableList<MutableList<Long>>): MutableList<MutableList<Long>> {
    val result = MutableList<MutableList<Long>>(n) { MutableList<Long>(n) { 0 } }
    for (i in 0 until n) {
        for (j in 0 until n) {
            for (k in 0 until n) {
                result[i][j] += matrix1[i][k] * matrix2[k][j]
            }
            result[i][j] = result[i][j] % 1000
        }
    }

    return result
}

