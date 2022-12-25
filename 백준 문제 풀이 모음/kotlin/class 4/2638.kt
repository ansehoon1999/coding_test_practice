

private lateinit var matrix : MutableList<MutableList<Int>>

val dr = listOf<Int>(1,-1,0,0)
val dc = listOf<Int>(0,0,1,-1)

fun main() = with(System.`in`.bufferedReader()){
    val (n,m) = readLine().split(' ').toList().map { it.toInt() }

    matrix = MutableList<MutableList<Int>>(n) { MutableList<Int> (m) { 0 } }

    for(i in 0 until n) {
        val input = readLine().split(' ').toList().map { it.toInt() }
        for (j in 0 until m) {
            matrix[i][j] = input[j]
        }
    }

    var sum = 0
    while (true) {
        var count = 0
        matrix.forEach {
            it.forEach {
                if (it == 1) count++
            }
        }

        if(count == 0) break


        bfs1(n, m)
        sum ++


    }

    print(sum)


}

fun bfs1(n: Int, m: Int) {
    val new_matrix = MutableList<MutableList<Int>>(n) { MutableList<Int> (m) { 0 } }
    for (i in 0 until n) {
        for (j in 0 until m) {
            new_matrix[i][j] = matrix[i][j]
        }
    }

    val deque = ArrayDeque<Pair<Int, Int>>()
    deque.add(Pair(0,0))
    new_matrix[0][0] = -1

    while (deque.isNotEmpty()) {
//        println(deque)
//        new_matrix.forEach {
//            println(it)
//        }
//        println()
        val node = deque.removeFirst()

        for (k in 0 until 4) {
            val nr = node.first + dr[k]
            val nc = node.second + dc[k]

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue

            if (new_matrix[nr][nc] == -1) continue


            if (new_matrix[nr][nc] == 1) {continue}
            else  {
                new_matrix[nr][nc] = -1
                deque.add(Pair(nr, nc))
            }
        }
    }

    bfs(n, m, new_matrix)
}

fun bfs(n: Int, m: Int, new_matrix : MutableList<MutableList<Int>>) {
//    new_matrix.forEach {
//        println(it)
//    }
//    println()

    val deque = ArrayDeque<Pair<Int, Int>>()

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (new_matrix[i][j] == 1) {
                var sub_count = 0
                for (k in 0 until 4) {
                    val nr = i + dr[k]
                    val nc = j + dc[k]

                    if (new_matrix[nr][nc] == -1) {
                        sub_count++
                    }
                }

                if (sub_count >=2) {
                    deque.add(Pair(i, j))
                }
            }
        }
    }


    while (deque.isNotEmpty()) {
        val node = deque.removeFirst()
//        println(node)

        new_matrix[node.first][node.second] = -1
        matrix[node.first][node.second] = 0


    }
}

