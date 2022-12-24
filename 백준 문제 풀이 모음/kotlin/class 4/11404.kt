
private val INF = Integer.MAX_VALUE / 2
private lateinit var matrix : MutableList<MutableList<Int>>

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    matrix = MutableList<MutableList<Int>>(n) { MutableList<Int>(n) { INF } }
//    for (i in 0 until n) {
//        for (j in 0 until n) {
//            if (i == j) matrix[i][j] = 0
//        }
//    }


    val m = readLine().toInt()

    repeat(m) {
        val (a,b,c) = readLine().split(' ').toList().map { it.toInt() }

        if (matrix[a-1][b-1] > c) {
            matrix[a - 1][b - 1] = c
        }

    }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (matrix[i][j] >= matrix[i][k] + matrix[k][j] && i!=j) {
                    matrix[i][j] = matrix[i][k] + matrix[k][j]
                }
            }
        }
    }

    val sb = StringBuilder()
    matrix.forEach {
        it.forEach {
            if (it == INF) {
                sb.append(0)
            } else {
                sb.append(it)
            }
            sb.append(' ')
        }
        sb.append('\n')
    }
    print(sb.toString())

}
