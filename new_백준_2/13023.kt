import java.io.BufferedReader
import java.io.InputStreamReader



var result = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     *
     */

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = hashMapOf<Int, MutableList<Int>>()

    repeat(n) {
        graph[it] = mutableListOf()
    }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a]?.add(b)
        graph[b]?.add(a)
    }

//    println(graph)

    repeat(n) {
        val visited = MutableList<Boolean>(n) { false }

        dfs(it, graph, visited, 1)

        if(result == 1) {
            println(1)
            return
        }
//        println(visited)

    }



    println(result)
    writer.flush()
    writer.close()
}

fun dfs(num: Int, graph: HashMap<Int, MutableList<Int>>, visited: MutableList<Boolean>, cnt: Int) {
//    println("cnt:${cnt}")

    if(cnt == 5) {
        result = 1
        return
    }

    visited[num] = true

    graph[num]?.forEach { next ->
        if(!visited[next]) {
            dfs(next, graph, visited, cnt+1)
        }
    }

    visited[num] = false
}














