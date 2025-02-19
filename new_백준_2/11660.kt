import java.io.BufferedReader
import java.io.InputStreamReader

data class Node(
    val start: Int,
    val end: Int,
    val time: Int
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     * 1 3 6 10
     * 3 8
     */

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val matrix = MutableList<MutableList<Long>>(n+1) {
        MutableList<Long>(n+1) { 0L }
    }

    repeat(n) { i ->
        val tmpList = br.readLine().split(" ").map { it.toLong() }
        for(j in 0 until tmpList.size) {
            matrix[i+1][j+1] = tmpList[j]
        }
    }

    for(i in 1 .. n) {
        for(j in 1 .. n) {
            matrix[i][j] = matrix[i][j] + matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1]
        }
    }

//    matrix.forEach {
//        println(it)
//    }


    repeat(m) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }

//        println("${matrix[x2][y2]} ${matrix[x1-1][y2]} ${matrix[x2][y1-1]} ${matrix[x2-1][y2-1]}")
        println(matrix[x2][y2] - matrix[x1-1][y2] - matrix[x2][y1-1] + matrix[x1-1][y1-1])
    }


    writer.flush()
    writer.close()
}















