package class3

var matrix = Array(0) { MutableList<Int>(0) {0} }
val sb = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    matrix = Array(n) { MutableList(n) { 0 } }

    for (i in 0 until n) {
        val str = readLine().toCharArray()

        for (j in 0 until n) {
                matrix[i][j] = Character.getNumericValue(str[j])
        }
    }

//    sb.append('(')
    divide(n, 0, 0)
//    sb.append(')')

//    matrix.forEach {
//        it.forEach {
//            print(it)
//            print(' ')
//        }
//        println()
//    }

    print(sb.toString())
}

fun divide(n: Int, rol: Int, col: Int) {
    val first = matrix[rol][col]
    var state = true

    for (i in rol until (rol+n)) {
        for (j in col until (col+n)) {
            if (matrix[i][j] != first) {
//                println("${i} ${j} ${matrix[i][j]}")
                state = false
                break
            }
        }
        if(!state) break
    }

    if (state) {
        sb.append(first)
        return
    } else {
        sb.append('(')
        val size = n / 2
        divide(size, rol, col)
        divide(size, rol, col+size)
        divide(size, rol+size, col)
        divide(size, rol+size, col+size)
        sb.append(')')
    }












}

