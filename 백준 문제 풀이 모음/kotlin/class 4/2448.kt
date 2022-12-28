

private lateinit var matrix : MutableList<MutableList<Char>>

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    matrix = MutableList<MutableList<Char>>(n) { MutableList<Char>(n *2 - 1) { ' ' } }

    triangle(0, n-1, n)

    val sb = StringBuilder()

    matrix.forEach {
        it.forEach {
            sb.append(it)
        }
        sb.append('\n')

    }
    print(sb)
}

fun triangle(rol: Int, col: Int, n: Int) {
    if (n == 3) {
        matrix[rol][col] = '*'
        matrix[rol+1][col-1] = '*'
        matrix[rol+1][col+1] = '*'
        matrix[rol+2][col-2] = '*'
        matrix[rol+2][col-1] = '*'
        matrix[rol+2][col] = '*'
        matrix[rol+2][col+1] = '*'
        matrix[rol+2][col+2] = '*'
    } else {

        val size = n / 2

        triangle(rol, col, size)
        triangle(rol + size, col - size, size)
        triangle(rol+size, col + size, size)

    }
}

