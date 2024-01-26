import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val graph = hashMapOf<Int, MutableList<Int>>()

    repeat(N) {
        graph[it+1] = mutableListOf<Int>()
    }

    repeat(M) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }

        graph[u]?.add(v)
        graph[v]?.add(u)
    }

    /**
     * Visited 생성
     */

    val visited = MutableList<Boolean>(N+1) { false }
    var total = 0

    /**
     * dfs 구하기
     */

//    println(graph)
    for(i in 1 .. N) {
        if(!visited[i]) {
            visited[i] = true
            dfs(graph, visited, i)
            total ++
        }
    }

    println(total)
}

fun dfs(graph: HashMap<Int, MutableList<Int>>, visited: MutableList<Boolean>, cur: Int) {

    graph[cur]?.forEach {

        if(!visited[it]) {
            visited[it] = true
            dfs(graph, visited, it)
        }
    }
}