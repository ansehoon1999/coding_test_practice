import java.io.BufferedReader
import java.io.InputStreamReader


data class Node(
    val num: Int,
    val depth: Int
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()


    val matrix = MutableList<MutableList<Int>>(31) {
        MutableList<Int>(31) { 0 }
    }

    for(i in 1 .. 30) {
        matrix[i][i] = 1
        matrix[i][1] = i
    }

    for(i in 1 .. 30) {
        for(j in 2 .. 30) {

            if(i > j) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i - 1][j - 1]
            }
        }
    }

    val T = br.readLine().toInt()

    repeat(T) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        writer.write("${matrix[maxOf(i, j)][minOf(i, j)]}\n")
    }

//    matrix.forEach {
//        println(it)
//    }



    writer.flush()
    writer.close()

}