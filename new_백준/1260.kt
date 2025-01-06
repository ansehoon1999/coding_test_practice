import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

val sb1 = StringBuilder()
val sb2 = StringBuilder()

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val v = st.nextToken().toInt()

    val hashMap = hashMapOf<Int, MutableList<Int>>()
    repeat(n) {
        hashMap[it + 1] = mutableListOf()
    }

    var visited = MutableList<Boolean>(n + 1) { false }

    repeat(m) {
        st = StringTokenizer(br.readLine())
        val v1 = st.nextToken().toInt()
        val v2 = st.nextToken().toInt()

        hashMap[v1]?.add(v2)
        hashMap[v2]?.add(v1)
    }

    for((key, value) in hashMap) {
        value.sort()
    }

    dfs(v, visited, hashMap)

    visited = MutableList(n+1) { false }

    bfs(v, visited, hashMap)

    println(sb1.toString().trim())
    println(sb2.toString().trim())
    //    bw.write("$sum")
    bw.flush()
    bw.close()
}

fun bfs(start: Int, visited: MutableList<Boolean>, hashMap: HashMap<Int, MutableList<Int>>) {
    val deque = ArrayDeque<Int>()
    deque.add(start)
    visited[start] = true

    while(deque.isNotEmpty()) {
        val now = deque.removeFirst()
        sb2.append(now)
        sb2.append(" ")

        hashMap[now]?.forEach { next ->

            if(!visited[next]) {
                visited[next] = true
                deque.add(next)
            }
        }
    }
}

fun dfs(start: Int, visited: MutableList<Boolean>, hashMap: HashMap<Int, MutableList<Int>>) {


    sb1.append(start)
    sb1.append(" ")

    visited[start] = true
    hashMap[start]?.forEach { next ->
        if (!visited[next]) {
            dfs(next, visited, hashMap)
        }
    }
}