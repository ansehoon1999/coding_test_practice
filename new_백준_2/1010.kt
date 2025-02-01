import java.io.BufferedReader
import java.io.InputStreamReader



fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     * 동쪽의 개수 n
     * 서쪽의 개수 m
     *
     * matrix[n][c]
     * nCs
     */

    val matrix = MutableList<MutableList<Long>>(31) {
        MutableList<Long>(31) {
            0
        }
    }

    for(i in 1 until 31) {
        matrix[1][i] = 1
        matrix[i][1] = i.toLong()
        matrix[i][i] = 1
    }

    for(i in 2 until 31) {
        for (j in 2 until 31) {
            if(i > j) {
                matrix[i][j] = matrix[i - 1][j - 1] + matrix[i - 1][j]
            }
        }
    }


    val T = br.readLine().toInt()
    repeat(T) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }

        writer.write("${matrix[m][n]}\n")
    }



    writer.flush()
    writer.close()
}