import kotlin.math.atan

enum class Direction { VERTICAL, HORIZONTAL, DIAGONAL }
private lateinit var matrix : MutableList<MutableList<Int>>
private var sum = 0
private var n = 0
fun main() = with(System.`in`.bufferedReader()){
    n = readLine().toInt()
    matrix = MutableList<MutableList<Int>>(n) { MutableList<Int>(n) { 0} }

    for (i in 0 until n) {
        val input = readLine().split(' ').toList().map { it.toInt() }
        for (j in 0 until n) {
            matrix[i][j] = input[j]
        }
    }


//    dfs(Pair(0,0), Pair(0,1), n)

    dfs (0, 1, Direction.HORIZONTAL)
    val sb = StringBuilder()
    sb.append(sum)
    println(sb)
}

fun dfs(x: Int, y: Int, direction : Direction) {
    if (x >= n || y >= n || matrix[x][y] == 1 ||
        (direction == Direction.DIAGONAL && (matrix[x - 1][y] == 1 || matrix[x][y - 1] == 1))
    ) return

    if (x == n - 1 && y == n - 1) {
        sum++
        return
    }
    when (direction) {
        Direction.HORIZONTAL -> {
            dfs(x, y + 1, Direction.HORIZONTAL)
            dfs(x + 1, y + 1, Direction.DIAGONAL)
        }

        Direction.VERTICAL -> {
            dfs(x + 1, y, Direction.VERTICAL)
            dfs(x + 1, y + 1, Direction.DIAGONAL)
        }

        Direction.DIAGONAL -> {
            dfs(x, y + 1, Direction.HORIZONTAL)
            dfs(x + 1, y, Direction.VERTICAL)
            dfs(x + 1, y + 1, Direction.DIAGONAL)
        }
    }
}
//
//fun dfs(before : Pair<Int, Int>, start: Pair<Int, Int>, n : Int) {
//    matrix.forEach {
//        println(it)
//    }
//    println()
//
//    if (start.first == n-1 && start.second == n-1) {
//        sum ++
//        return
//    }
//
//    else {
//
//
//        if (start.first == before.first && start.second == before.second + 1) {  // 가로 파이프
//
//            if (start.second == n-1) return
//
//
//            if (start.second+1 < n) {
//                if (matrix[start.first][start.second + 1] != 1) {
//                    matrix[start.first][start.second + 1] = 1
//                    dfs(start, Pair(start.first, start.second + 1), n)
//                    matrix[start.first][start.second + 1] = 0
//                }
//            }
//            if (start.first + 1 < n && start.second + 1 < n) {
//                if (matrix[start.first][start.second + 1] != 1 && matrix[start.first + 1][start.second + 1] != 1 && matrix[start.first + 1][start.second] != 1) {
//                    matrix[start.first + 1][start.second + 1] = 1
//                    dfs(start, Pair(start.first + 1, start.second + 1), n)
//                    matrix[start.first + 1][start.second + 1] = 0
//                }
//            }
//        }
//
//        if (start.first == before.first + 1 && start.second == before.second) { // 세로 파이프
//            if (start.first == n-1) return
//
//            if (start.first+1 < n) {
//                if (matrix[start.first + 1][start.second] != 1) {
//                    matrix[start.first + 1][start.second] = 1
//                    dfs(start, Pair(start.first + 1, start.second), n)
//                    matrix[start.first + 1][start.second] = 0
//                }
//            }
//
//            if (start.first + 1 < n && start.second + 1 < n) {
//                if (matrix[start.first][start.second + 1] != 1 && matrix[start.first + 1][start.second + 1] != 1 && matrix[start.first + 1][start.second] != 1) {
//                    matrix[start.first + 1][start.second + 1] = 1
//                    dfs(start, Pair(start.first + 1, start.second + 1), n)
//                    matrix[start.first + 1][start.second + 1] = 0
//                }
//            }
//        }
//
//        if (start.first == before.first + 1 && start.second == before.second + 1) {
//            if (start.second+1 < n) {
//                if (matrix[start.first][start.second + 1] != 1) {
//                    matrix[start.first][start.second + 1] = 1
//                    dfs(start, Pair(start.first, start.second + 1), n)
//                    matrix[start.first][start.second + 1] = 0
//                }
//            }
//            if (start.first+1 < n) {
//                if (matrix[start.first + 1][start.second] != 1) {
//                    matrix[start.first + 1][start.second] = 1
//                    dfs(start, Pair(start.first + 1, start.second), n)
//                    matrix[start.first + 1][start.second] = 0
//                }
//            }
//
//            if (start.first + 1 < n && start.second + 1 < n) {
//                if (matrix[start.first][start.second + 1] != 1 && matrix[start.first + 1][start.second + 1] != 1 && matrix[start.first + 1][start.second] != 1 && start.first + 1 < n && start.second + 1 < n) {
//                    matrix[start.first + 1][start.second + 1] = 1
//                    dfs(start, Pair(start.first + 1, start.second + 1), n)
//                    matrix[start.first + 1][start.second + 1] = 0
//                }
//            }
//        }
//
//    }
//}



