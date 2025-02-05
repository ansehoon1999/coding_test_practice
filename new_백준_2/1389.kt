import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack
import kotlin.math.cos


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()


    /**
     * 다익스트라 알고리즘
     */

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = MutableList<MutableList<Int>>(n+1) {
        MutableList<Int>(n+1) { Integer.MAX_VALUE / 2 }
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

    var minValue = Integer.MAX_VALUE / 2
    var result = 0

    for(i in 1 .. n) {
        var tempSum = 0
        for(j in 1 .. n) {
            tempSum += graph[i][j]
        }

        if(minValue > tempSum) {
            minValue = tempSum
            result = i
        }
    }

    println(result)

//    val graph = hashMapOf<Int, MutableList<Int>>()
//
//    repeat(n) {
//        graph[it+1] = mutableListOf()
//    }
//
//    repeat(m) {
//        val (a, b) = br.readLine().split(" ").map { it.toInt() }
//        graph[a]?.add(b)
//        graph[b]?.add(a)
//    }
//
//    fun bfs(num: Int): Int {
//
//        val visited = MutableList<Boolean>(n + 1) { false }
//        val values = MutableList<Int>(n+1) { 0 }
//
//        val deque = ArrayDeque<Int>()
//        deque.add(num)
//        visited[num] = true
//
//        while(deque.isNotEmpty()) {
//            val cur = deque.removeFirst()
//
//            graph[cur]?.forEach { next ->
//                if(!visited[next]) {
//                    visited[next] = true
//                    values[next] = values[cur] + 1
//                    deque.add(next)
//                }
//            }
//        }
//
//
//        return values.sum()
//    }
//
//    var tmpMin = Integer.MAX_VALUE
//    var tmpMinIdx = 0
//
//
//    for(i in 1 .. n) {
//        val sum = bfs(i)
//
//        if(tmpMin > sum) {
//            tmpMin = sum
//            tmpMinIdx = i
//        }
//    }
//
//    println(tmpMinIdx)
//

    writer.flush()
    writer.close()
}


