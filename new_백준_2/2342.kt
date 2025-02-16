import java.io.BufferedReader
import java.io.InputStreamReader


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     *
     */

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = hashMapOf<Int, MutableList<Int>>()
    val inDegrees = MutableList<Int>(n+1) { 0 }

    repeat(n) {
        graph[it+1] = mutableListOf()
    }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }

        graph[a]?.add(b)
        inDegrees[b] += 1
    }

    val visited = MutableList<Boolean>(n+1) { false }

    val deque = ArrayDeque<Int>()

    for(i in 1 .. n) {
        if(inDegrees[i] == 0) {
            deque.add(i)
        }
    }

    val result = mutableListOf<Int>()

    while(deque.isNotEmpty()) {
        val cur = deque.removeFirst()
        result.add(cur)

        graph[cur]?.forEach { next ->

            inDegrees[next] --

            if(inDegrees[next] == 0) {
                deque.add(next)
            }
        }
    }

    result.forEach {
        print("$it ")
    }
}














