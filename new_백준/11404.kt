import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val graph = Array<IntArray>(n+1) {
        IntArray(n+1) { Int.MAX_VALUE / 2 }
    }

    for(i in 1 .. n) {
        for(j in 1 .. n) {
            if(i == j) {
                graph[i][j] = 0
            }
        }
    }

    repeat(m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        graph[a][b] = minOf(graph[a][b], c)
    }

    for(k in 1 .. n) {
        for(i in 1 .. n) {
            for(j in 1 .. n) {
                if(i != j) {

                    if(graph[i][j] >= graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j]
                    }
                }
            }
        }
    }


    for(i in 1 .. n) {
        for(j in 1 .. n) {
            print("${if(graph[i][j] >= Int.MAX_VALUE / 2) 0 else graph[i][j]} ")
        }
        println()
    }

    bw.flush()
    bw.close()
}

