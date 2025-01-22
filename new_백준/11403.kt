import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    val graph = mutableListOf<IntArray>()

    repeat(n) {
        val tempList = br.readLine().split(" ").map {
            if (it.toInt() == 0) {
                Integer.MAX_VALUE / 2
            } else {
                it.toInt()
            }
        }.toIntArray()
        graph.add(tempList)
    }


    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                graph[i][j] = minOf(graph[i][j], graph[i][k] + graph[k][j])
            }
        }
    }

    for(i in 0 until n) {
        for(j in 0 until n) {
            print("${if(graph[i][j] == Integer.MAX_VALUE / 2 || graph[i][j] == 0) 0 else 1} ")
        }
        println()
    }




    bw.flush()
    bw.close()
}

