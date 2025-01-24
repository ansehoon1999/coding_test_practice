import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

data class Edge(
    val start: Int,
    val end: Int,
    val length: Int
)

val rList = listOf(0, 0, 1, -1)
val cList = listOf(1, -1, 0, 0)

lateinit var graph: MutableList<MutableList<Int>>
lateinit var edges: MutableList<Edge>
lateinit var parent: MutableList<Int>

var landCnt = 1

fun main() {

    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    graph = mutableListOf<MutableList<Int>>()

    repeat(n) {
        val tmpStr = br.readLine().split(" ").map {
            if (it.toInt() == 1) -1
            else it.toInt()
        }
        graph.add(tmpStr.toMutableList())
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == -1) {
                bfs(i, j, n, m)
                landCnt++
            }
        }
    }

    landCnt -= 1

//    graph.forEach {
//        println(it)
//    }

    edges = mutableListOf<Edge>()

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] != 0) {
                findPath(i, j, n, m)
            }
        }
    }

//    println(landCnt)

    parent = MutableList<Int>(landCnt + 100) { it }

    edges.sortBy { it.length }

    var result = 0
    var cnt = 0
    edges.forEach { edge ->

        if (find(edge.start) != find(edge.end)) {
            union(edge.start, edge.end)

//            println(edge)
            result += edge.length
            cnt ++
        }
    }

    if(cnt == landCnt - 1) {
        println(result)
    } else {
        println(-1)
    }


    bw.flush()
    bw.close()

}

fun find(a: Int): Int {
    if (a == parent[a]) return parent[a]
    else {
        parent[a] = find(parent[a])
        return parent[a]
    }
}

fun union(a: Int, b: Int) {
    val a1 = find(a)
    val b1 = find(b)

    parent[b1] = a1
}

fun findPath(curR: Int, curC: Int, n: Int, m: Int) {

    for (i in 0 until 4) {

        var bridgeLength = 0
        var flag = true

        var nextR = curR
        var nextC = curC

        while (true) {

            nextR += rList[i]
            nextC += cList[i]

            if (nextR !in 0 until n || nextC !in 0 until m) {
                flag = false
                break
            }

            if (graph[nextR][nextC] == 0) {
                bridgeLength++
                continue
            } else if (graph[nextR][nextC] == graph[curR][curC]) {
                flag = false
                break
            } else if (graph[nextR][nextC] != graph[curR][curC]) {
                break
            }
        }

        if(!flag) continue

        if (bridgeLength >= 2) {
            edges.add(
                Edge(
                    start = graph[curR][curC],
                    end = graph[nextR][nextC],
                    length = bridgeLength
                )
            )
        }
    }

//    println(edges)
//    println()

}

fun bfs(r: Int, c: Int, n: Int, m: Int) {

    val deque = ArrayDeque<Pair<Int, Int>>()
    deque.add(Pair(r, c))
    graph[r][c] = landCnt

    while (deque.isNotEmpty()) {
        val cur = deque.removeFirst()
        val curR = cur.first
        val curC = cur.second

        for (i in 0 until 4) {
            val nextR = curR + rList[i]
            val nextC = curC + cList[i]

            if (nextR !in 0 until n || nextC !in 0 until m) continue

            if (graph[nextR][nextC] != -1) continue

            graph[nextR][nextC] = landCnt
            deque.add(Pair(nextR, nextC))
        }
    }

}
