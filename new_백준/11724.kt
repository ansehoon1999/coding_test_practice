import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

var cnt = 0

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))
    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()


    val visited = MutableList<Boolean>(n+1) { false }
    val hashMap = hashMapOf<Int, MutableList<Int>>()
    repeat(n) {
        hashMap[it+1] = mutableListOf()
    }

    repeat(m) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        hashMap[u]?.add(v)
        hashMap[v]?.add(u)
    }

    var cnt = 0

    for(idx in 1 .. n) {
        if(!visited[idx]) {
            dfs(hashMap, visited, idx)
            cnt ++
        }
    }

    println(cnt)
//    bw.write("$sum")
    bw.flush()
    bw.close()
}

fun dfs(hashMap: HashMap<Int, MutableList<Int>>, visited: MutableList<Boolean>, num: Int) {

    visited[num] = true

    hashMap[num]?.forEach {
        if(!visited[it]) {
            dfs(hashMap, visited, it)
        }
    }
}

