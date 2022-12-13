package class3

var matrix = Array(0) { MutableList(0) { 0 } }
var minusone = 0
var one = 0
var zero = 0
fun main () = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    matrix = Array(n) { MutableList(n) { 0 } }

    for (i in 0 until n) {
        val input = readLine().split(' ').toMutableList()

        for (j in 0 until n) {
            matrix[i][j] = input[j].toInt()
        }

    }


//    matrix.forEach {
//        it.forEach {
//            print(it)
//            print(' ')
//        }
//        println()
//    }

    divide(n, 0, 0)

    println(minusone)
    println(zero)
    println(one)
}

fun divide(n: Int, rol : Int, col : Int) {
    val first = matrix[rol][col]
    var state = true

//    for (i in rol until rol + n) {
//        for (j in col until col + n) {
//            print(matrix[i][j])
//            print(' ')
//        }
//        println()
//    }

    for (i in rol until rol + n) {
        for (j in col until col + n) {
            if (matrix[i][j] != first) {
                state = false
                break
            }
        }
        if (!state) break
    }

    if(state) {
        if (first == 1) {
            one ++
        } else if (first == 0 ) {
            zero ++
        } else if (first == -1) {
            minusone ++
        }

        return
    } else {
        val size = n / 3
        divide(size, rol, col)
        divide(size, rol, col + size)
        divide(size, rol, col + size * 2)
        divide(size, rol + size, col)
        divide(size, rol + size, col + size)
        divide(size, rol + size, col + size * 2)
        divide(size, rol + size * 2, col)
        divide(size, rol + size * 2, col + size)
        divide(size, rol + size * 2, col + size * 2)
    }




}
