import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

lateinit var visited: BooleanArray
lateinit var parent: IntArray

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()

    val graph = hashMapOf<Int, MutableList<Int>>()
    repeat(n) {
        graph[it+1] = mutableListOf()
    }

    visited = BooleanArray(n+1) { false }
    parent = IntArray(n+1) { it }

    repeat(n-1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a]?.add(b)
        graph[b]?.add(a)
    }

    visited[1] = true

    for(node in 1 .. n) {
        dfs(node, graph)
    }

    for(i in 2 .. n) {
        println(parent[i])
    }


    bw.flush()
    bw.close()

}

fun dfs(cur: Int, graph: HashMap<Int, MutableList<Int>>) {

    graph[cur]?.forEach { next ->

        if(!visited[next]) {
            visited[next] = true
            parent[next] = cur
            dfs(next, graph)
        }
    }

}