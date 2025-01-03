import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

var result = false
fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val hashMap = hashMapOf<Int, MutableList<Int>>()
    val visited = MutableList<Boolean>(n) { false }

    repeat(n) {
        hashMap[it] = mutableListOf()
    }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        hashMap[a]?.add(b)
        hashMap[b]?.add(a)
    }

    repeat(n) {
        if(!visited[it]) {
            dfs(visited, hashMap, it)
        }

        if(result) {
            println(1)
            return
        }

    }
    println(0)
    //    bw.write("$sum")
    bw.flush()
    bw.close()
}

fun dfs(visited: MutableList<Boolean>, hashMap: HashMap<Int, MutableList<Int>>, start: Int, depth: Int = 1) {

    if(depth == 5) {
        result = true
        return
    }

    visited[start] = true
    hashMap[start]?.forEach { next ->
        if(!visited[next]) {
            dfs(visited, hashMap, next, depth + 1)
        }
    }

    visited[start] = false

}

