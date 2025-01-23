import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

lateinit var visited: BooleanArray
lateinit var parent: IntArray

var result = 0

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()

    visited = BooleanArray(n) { false }
    parent = IntArray(n) { it }

    st = StringTokenizer(br.readLine())
    repeat(n) {
        parent[it] = st.nextToken().toInt()
    }

    st = StringTokenizer(br.readLine())
    parent[st.nextToken().toInt()] = Integer.MIN_VALUE
    
    var startIdx = - 1
    for(i in 0 until parent.size) {
        if(parent[i] == -1) {
            startIdx = i
            break
        }
    }

    if(startIdx == -1) {
        println(0)
        return
    }


    visited[startIdx] = true
    dfs(startIdx)

    println(result)
    bw.flush()
    bw.close()

}

fun dfs(cur: Int) {

    var curCnt = 0

    for(nextIdx in 0 until parent.size) {

        if(visited[nextIdx]) continue

        if(parent[nextIdx] == cur) {
            visited[nextIdx] = true
            dfs(nextIdx)
            curCnt ++
        }

    }

    if(curCnt == 0) {
        result ++
    }

}