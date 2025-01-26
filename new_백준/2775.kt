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

    val t = br.readLine().toInt()

    var matrix = MutableList<MutableList<Int>>(16) {
        MutableList<Int>(16) { 0 }
    }

    for(i in 1 .. 15) {
        matrix[0][i] = i
    }

    for(i in 1 .. 15) {
        for(j in 1 .. 15) {
            matrix[i][j] = matrix[i][j-1] + matrix[i-1][j]
        }
    }

    repeat(t) {
        val k = br.readLine().toInt()
        val n = br.readLine().toInt()




        writer.write("${matrix[k][n]}\n")
    }

    writer.flush()
    writer.close()

}