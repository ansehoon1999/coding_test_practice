package class3


var matrix = Array(0) { MutableList<Int>(0) { 0 } }
var arr_rol = listOf<Int>(0,0,1,-1)
var arr_col = listOf<Int>(1,-1,0,0)

var count = 0
fun main () = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    matrix = Array(n) { MutableList(n) { 0 } }

    for (i in 0 until n) {
        val input = readLine().toCharArray()
        for (j in 0 until n) {
            matrix[i][j] = Character.getNumericValue(input[j])
        }
    }

//    matrix.forEach {
//        println(it)
//    }
    val result = mutableListOf<Int>()

    for (i in 0 until n) {
        for (j in 0 until n) {
            if(matrix[i][j] == 1) {
                count = 0
                DFS(n, i, j)
                result.add(count)
            }
        }
    }

    val sb = StringBuilder()
    result.sort()

    sb.append(result.size)
    sb.append('\n')
    result.forEach {
        sb.append(it)
        sb.append('\n')
    }
    println(sb.toString())
//    println(result)

}

fun DFS(n : Int, rol: Int, col: Int) {
    matrix[rol][col] = 0
    count ++

    var new_rol = 0
    var new_col = 0
    for (i in 0 until 4) {
        new_rol = rol + arr_rol[i]
        new_col = col + arr_col[i]

        if (!((0<= new_rol && new_rol < n) && (0<= new_col && new_col < n))) continue
        if (matrix[new_rol][new_col] == 0) continue

        DFS(n, new_rol, new_col)

    }



}
