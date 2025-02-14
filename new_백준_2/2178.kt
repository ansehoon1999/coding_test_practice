import java.io.BufferedReader
import java.io.InputStreamReader

data class Point(
    val r: Int,
    val c: Int,
    val cnt: Int
)

val rList = listOf(1, -1, 0, 0)
val cList = listOf(0, 0, 1, -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

   val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val matrix = MutableList<MutableList<Int>>(n) {
        MutableList<Int>(m) { 0 }
    }

    repeat(n) { i ->
        val tmpList = br.readLine().toList().map { it.toString().toInt() }
        tmpList.forEachIndexed { j, tmp ->
            matrix[i][j] = tmpList[j]
        }
    }

    val visited = MutableList<MutableList<Boolean>>(n) {
        MutableList<Boolean>(m) { false }
    }

    for(i in 0 until n) {
        for(j in 0 until m) {
            if(matrix[i][j] == 0) {
                visited[i][j] = true
            }
        }
    }

    val deque = ArrayDeque<Point>()
    deque.add(Point(0, 0, 1))
    visited[0][0] = true


    while(deque.isNotEmpty()) {
        val cur = deque.removeFirst()

        if(cur.r == n - 1 && cur.c == m - 1) {
            println(cur.cnt)
            continue
        }

        for(i in 0 until 4) {
            val nextR = cur.r + rList[i]
            val nextC = cur.c + cList[i]

            if(nextR !in 0 until n || nextC !in 0 until m) continue

            if(!visited[nextR][nextC]) {
                visited[nextR][nextC] = true
                deque.add(Point(nextR, nextC, cur.cnt + 1))
            }
        }
    }


//    matrix.forEach {
//        println(it)
//    }
}














