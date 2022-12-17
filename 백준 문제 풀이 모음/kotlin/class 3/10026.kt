

var matrix1 = MutableList<MutableList<Char>>(0) { MutableList<Char>(0) { '0' } }
var matrix2 = MutableList<MutableList<Char>>(0) { MutableList<Char>(0) { '0' } }
var count1 = 0
var count2 = 0

val dr = listOf<Int>(1,-1,0,0)
val dc = listOf<Int>(0,0,1,-1)
fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    matrix1 = MutableList(n) { MutableList<Char>(n) { '0' } }
    matrix2 = MutableList(n) { MutableList<Char>(n) { '0' } }

    for (i in 0 until n) {
        val input = readLine().toCharArray()
        for ( j in 0 until n) {
            matrix1[i][j] = input[j]
            matrix2[i][j] = input[j]
        }
    }

    for ( i in 0 until n) {
        for (j in 0 until n) {
            if (matrix1[i][j] != '0') {
//                println("=======")
                BFS1(i, j, n)
                count1 ++
            }
        }
    }
    print(count1)
    print(' ')
    for ( i in 0 until n) {
        for (j in 0 until n) {
            if (matrix2[i][j] != '0') {
//                println("=======")
                BFS2(i, j, n)
                count2 ++
            }
        }
    }
    print(count2)
}

fun BFS1(rol: Int, col: Int, n: Int) {
    val deque = ArrayDeque<Pair<Int, Int>>()
    deque.add(Pair<Int, Int>(rol, col))

    while (deque.size != 0 ) {
//        matrix1.forEach {
//            println(it)
//        }
//        println()
//        println(deque)
        val node = deque.removeFirst()
        val color = matrix1[node.first][node.second]
        matrix1[node.first][node.second] = '0'
        for (k in 0 until 4) {
            var new_r = node.first + dr[k]
            var new_c = node.second + dc[k]

            if ( new_r < 0 || new_r >= n || new_c <0 || new_c >= n ) {
                continue
            }

            if (color == 'R') {
                if (matrix1[new_r][new_c] == 'R') {
                    deque.add(Pair<Int, Int>(new_r, new_c))
                }
            } else if (color == 'B') {
                if (matrix1[new_r][new_c] == 'B') {
                    deque.add(Pair<Int, Int>(new_r, new_c))
                }
            } else if (color == 'G') {
                if (matrix1[new_r][new_c] == 'G') {
                    deque.add(Pair<Int, Int>(new_r, new_c))
                }
            }


        }

    }
}

fun BFS2(rol: Int, col: Int, n: Int) {
    val deque = ArrayDeque<Pair<Int, Int>>()
    deque.add(Pair<Int, Int>(rol, col))

    while (deque.size != 0 ) {
//        matrix1.forEach {
//            println(it)
//        }
//        println()
//        println(deque)
        val node = deque.removeFirst()
        val color = matrix2[node.first][node.second]
        matrix2[node.first][node.second] = '0'
        for (k in 0 until 4) {
            var new_r = node.first + dr[k]
            var new_c = node.second + dc[k]

            if ( new_r < 0 || new_r >= n || new_c <0 || new_c >= n ) {
                continue
            }

            if (color == 'R') {
                if (matrix2[new_r][new_c] == 'R' || matrix2[new_r][new_c] == 'G' ) {
                    deque.add(Pair<Int, Int>(new_r, new_c))
                }
            } else if (color == 'B') {
                if (matrix2[new_r][new_c] == 'B') {
                    deque.add(Pair<Int, Int>(new_r, new_c))
                }
            } else if (color == 'G') {
                if (matrix2[new_r][new_c] == 'R' || matrix2[new_r][new_c] == 'G') {
                    deque.add(Pair<Int, Int>(new_r, new_c))
                }
            }


        }

    }
}
