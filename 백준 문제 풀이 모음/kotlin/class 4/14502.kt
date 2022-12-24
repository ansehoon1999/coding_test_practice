


private var row = -1
private var col = -1
private var sum = 0
private var dr = listOf<Int>(1,-1,0,0)
private var dc = listOf<Int>(0,0,1,-1)

fun main() = with(System.`in`.bufferedReader()){
    val (row1, col1) = readLine().split(' ').toList().map { it.toInt() }
    row = row1
    col = col1

    var matrix = MutableList<MutableList<Int>>(row) { MutableList<Int>(col) { 0 } }

    for (i in 0 until row) {
        val input = readLine().split(' ').toList().map { it.toInt() }
        for (j in 0 until col) {
            matrix[i][j] = input[j]
        }
    }

    for (i in 0 until row) {
        for (j in 0 until col) {
            if (matrix[i][j] == 0) {
                matrix[i][j] = 1
                dfs(0, matrix)
                matrix[i][j] = 0
            }
        }
    }
    println(sum)
}

fun dfs(idx: Int, matrix : MutableList<MutableList<Int>>) {
    if (idx == 2) {

        val count = bfs(matrix)
        sum = Math.max(count, sum)
    } else {
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = 1
                    dfs(idx + 1, matrix)
                    matrix[i][j] = 0
                }
            }
        }
    }


}

fun bfs(matrix : MutableList<MutableList<Int>>) : Int {
    val new_matrix = MutableList<MutableList<Int>>(row) { MutableList<Int>(col) { 0 } }
    for (i in 0 until row) {
        for (j in 0 until col) {
            new_matrix[i][j] = matrix[i][j]
        }
    }


    val deque = ArrayDeque<Pair<Int, Int>>()

    for (i in 0 until row) {
        for (j in 0 until col) {
            if (new_matrix[i][j] == 2) {
                deque.add(Pair(i, j))
            }
        }
    }

    while (deque.isNotEmpty()) {
        val node = deque.removeFirst()

        for (xx in 0 until 4) {
            val nr = node.first + dr[xx]
            val nc = node.second + dc[xx]

            if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
                continue
            }

            if (new_matrix[nr][nc] == 0) {
                new_matrix[nr][nc] = 2
                deque.add(Pair(nr, nc))
            }
        }
    }

    var count = 0
    for (i in 0 until row) {
        for (j in 0 until col) {
            if (new_matrix[i][j] == 0) {
                count ++
            }
        }
    }

//    new_matrix.forEach {
//        println(it)
//    }
//    println()

    return count
}

