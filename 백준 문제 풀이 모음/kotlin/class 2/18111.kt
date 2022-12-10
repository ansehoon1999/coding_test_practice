

fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine().split(' ').toList()
    val n = str[0].toInt()
    val m = str[1].toInt()
    val b = str[2].toInt()

    val matrix = Array (n) {Array<Int>(m) {0} }

    for (i in 0 until n) {
        val input = readLine().split(' ').toList()
        for (j in 0 until m) {
            matrix[i][j] = input[j].toInt()
        }
    }

    var min = 1000000000
    var floor = 0
    for (k in 0 until 257) {
        var take = 0
        var put = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (matrix[i][j] -  k > 0) {
                    take += matrix[i][j] -  k
                } else if (matrix[i][j] -  k < 0) {
                    put +=  k - matrix[i][j]
                }
            }
        }

        if (put > take + b) {
            continue
        }

        if (min >= 2 * take + put) {
            min = 2 * take + put
            floor = k
        }
    }
    val sb = StringBuilder()

    sb.append(min)
    sb.append(' ')
    sb.append(floor)
    print(sb)
//
//    matrix.forEach {
//        it.forEach {
//            sb.append(it)
//            sb.append(' ')
//        }
//        sb.append('\n')
//    }
//
//    print(sb)

}
