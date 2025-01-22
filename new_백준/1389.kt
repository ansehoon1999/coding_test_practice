import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array<IntArray>(n + 1) {
        IntArray(n + 1) { Integer.MAX_VALUE / 2 }
    }

    for(i in 1 .. n) {
        for(j in 1 .. n) {

            if(i == j) {
                graph[i][j] = 0
            }
        }
    }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a][b] = 1
        graph[b][a] = 1
    }

    for(k in 1 .. n) {
        for(i in 1 .. n) {
            for(j in 1 .. n) {
                if(i != j) {
                    graph[i][j] = minOf(graph[i][j], graph[i][k] + graph[k][j])
                }
            }
        }
    }

//    graph.forEach {
//        println(it.toList())
//    }

    var minCnt = Integer.MAX_VALUE
    var minIdx = 0

    for(i in 1 .. n) {
        var tempSum = 0
        for(j in 1 .. n) {
            tempSum += graph[i][j]
        }

        if(minCnt > tempSum) {
            minCnt = tempSum
            minIdx = i
        }
    }

    println(minIdx)
    bw.flush()
    bw.close()
}

