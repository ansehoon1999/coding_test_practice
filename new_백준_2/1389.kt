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

    val graph = hashMapOf<Int, MutableList<Int>>()

    repeat(n) {
        graph[it+1] = mutableListOf()
    }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a]?.add(b)
        graph[b]?.add(a)
    }

    fun bfs(num: Int): Int {

        val visited = MutableList<Boolean>(n + 1) { false }
        val values = MutableList<Int>(n+1) { 0 }

        val deque = ArrayDeque<Int>()
        deque.add(num)
        visited[num] = true

        while(deque.isNotEmpty()) {
            val cur = deque.removeFirst()

            graph[cur]?.forEach { next ->
                if(!visited[next]) {
                    visited[next] = true
                    values[next] = values[cur] + 1
                    deque.add(next)
                }
            }
        }


        return values.sum()
    }

    var tmpMin = Integer.MAX_VALUE
    var tmpMinIdx = 0


    for(i in 1 .. n) {
        val sum = bfs(i)

        if(tmpMin > sum) {
            tmpMin = sum
            tmpMinIdx = i
        }
    }

    println(tmpMinIdx)





    writer.flush()
    writer.close()
}


