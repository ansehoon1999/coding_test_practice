import kotlin.system.exitProcess

private lateinit var matrix : MutableList<MutableList<Int>>
private lateinit var array : MutableList<Pair<Int, Int>>
private var arr_size = 1

val sb = StringBuilder()
fun main() = with(System.`in`.bufferedReader()){
    matrix = MutableList<MutableList<Int>>(9) { MutableList<Int>(9) { 0 } }
    array = mutableListOf()

    for(i in 0 until 9) {
        val input = readLine().toCharArray()
        for(j in 0 until 9) {
            matrix[i][j] = Character.getNumericValue(input[j])
            if (matrix[i][j] == 0) {
                array.add(Pair(i,j))
            }
        }
    }

    arr_size = array.size
    dfs(0)


//    println(array)
//
//    println()
//    matrix.forEach {
//        println(it)
//    }
}

fun dfs(depth : Int) {
//    print(arr_size)
//    println(depth)
//    matrix.forEach {
//        println(it)
//    }
//    println()

    if (depth == arr_size) {
        matrix.forEach {
            it.forEach {
                sb.append(it)
            }
            sb.append('\n')
        }
        println(sb)
        exitProcess(0)
    }

    val point = array[depth]
    val foundkey = findKeys(point.first, point.second)
//    println("find keys=====")
//    println(foundkey)
//    println("===========")
    foundkey.forEach {
        matrix[point.first][point.second] = it
        dfs(depth+1)
        matrix[point.first][point.second] = 0
    }
}

fun findKeys(row: Int, col: Int): MutableList<Int> {
    val result = mutableListOf<Int>()

    val state = MutableList<Boolean>(10) { false }

    for (i in 0 until 9) {
        if (matrix[row][i] != 0 && i != col) {
            state[matrix[row][i]] = true
        }
    }
//    println(state)

    for (i in 0 until 9) {
        if (matrix[i][col] != 0 && i != row) {
            state[matrix[i][col]] = true
        }
    }
//    println(state)

    val small_row = (row / 3) * 3
    val small_col = (col / 3) * 3

    for (i in small_row until small_row + 3) {
        for (j in small_col until small_col + 3) {
            if (matrix[i][j] != 0 && i != row && j != col) {
                state[matrix[i][j]] = true
            }
        }
    }
//    println(state)

    for (i in 1 .. 9) {
        if (!state[i]) {
            result.add(i)
        }
    }

    return result
}



