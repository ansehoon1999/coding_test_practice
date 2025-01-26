import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer


data class Node(
    val num: Int,
    val depth: Int
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val (n, k) = br.readLine().split(" ").map { it.toInt()}

    val matrix = MutableList<MutableList<Int>>(n + 1) {
        MutableList<Int>(n+1) { 0 }
    }

    for(i in 1 .. n) {
        matrix[i][1] = i
        matrix[i][i] = 1
        matrix[i][0] = 1
    }



    for(i in 2 .. n) {
        for(j in 1 .. n) {
            matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-1]
        }
    }

    println(matrix[n][k])

    writer.flush()
    writer.close()

}