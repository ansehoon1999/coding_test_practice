import java.io.*;
import java.util.*;
import kotlin.collections.ArrayDeque


var dfsFlag = false
var dfsList = listOf<Int>()

var bfsFlag = false
val sb = StringBuilder()


fun main() {

    val br = BufferedReader( InputStreamReader(System.`in`) )
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val V = st.nextToken().toInt()


    val hashMap = hashMapOf<Int, MutableList<Int>>()

    val visitedDFS = MutableList<Boolean>(N+1) { false }
    val visitedBFS = MutableList<Boolean>(N+1) { false }

    repeat(N) {
        hashMap[it+1] = mutableListOf()
    }

    for(i in 1 .. M) {
       st = StringTokenizer(br.readLine())
       val x = st.nextToken().toInt()
       val y = st.nextToken().toInt()

        hashMap[x]?.add(y)
        hashMap[y]?.add(x)
    }

    for((key, value) in hashMap) {
        value.sort()
    }


    visitedDFS[V] = true
    dfs(V, hashMap, visitedDFS, listOf<Int>(V), N)

//    println(dfsList)

    // bfs

    visitedBFS[V] = true
    val bfsList = bfs(V, hashMap, visitedBFS)

//    println(bfsList)

    sb.append("\n")


    bfsList.forEach {
        sb.append(it.toString())
        sb.append(" ")
    }

    println(sb.toString())

}



fun dfs(curIdx: Int, hashMap: HashMap<Int, MutableList<Int>>, visited: MutableList<Boolean>, list: List<Int>, total: Int) {

    sb.append("${curIdx} ")

    hashMap[curIdx]?.forEach {
        if(!visited[it]) {
            visited[it] = true
            dfs(it, hashMap, visited, list + listOf(it), total)
        }
    }


}

fun bfs(curIdx: Int, hashMap: HashMap<Int, MutableList<Int>>, visited: MutableList<Boolean>): List<Int> {

    val pq = ArrayDeque<Int>()
    pq.add(curIdx)
    visited[curIdx] = true

    val result = mutableListOf<Int>()
    result.add(curIdx)

    while(pq.isNotEmpty()) {
        val first = pq.removeFirst()

        hashMap[first]?.forEach {

            if(!visited[it]) {
                visited[it] = true
                result.add(it)
                pq.add(it)
            }
        }
    }

    return result.toList()
}