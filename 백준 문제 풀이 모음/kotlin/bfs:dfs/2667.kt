
import java.io.BufferedReader
import java.io.InputStreamReader

val dr = listOf(1, -1, 0, 0)
val dc = listOf(0, 0, 1, -1)

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val visited = mutableListOf<MutableList<Int>>()

    repeat(n) {
        val list = br.readLine().toList().map { it.toString().toInt() }.toMutableList()
        visited.add(list)
    }

    val result = mutableListOf<Int>()

    for(r in 0 until n) {
        for(c in 0 until n) {
            if(visited[r][c] == 1) {
                val num = bfs(r, c, visited, n)
                result.add(num)
            }
        }
    }

    result.sort()

    val sb = StringBuilder()
    sb.apply{
        append(result.size)
        append("\n")

        result.forEachIndexed { idx, num ->
            if(idx == result.size - 1) {
                append(num)
            } else {
                append(num)
                append("\n")
            }
        }
    }
    println(sb.toString())
}

fun bfs(r: Int, c: Int, visited: MutableList<MutableList<Int>>, n: Int): Int {

    val deque = ArrayDeque<Pair<Int, Int>>()
    deque.add(Pair(r, c))
    visited[r][c] = 0

    var tmpCnt = 0

    while(deque.isNotEmpty()) {
        val (curR, curC) = deque.removeFirst()
        tmpCnt ++

        for(i in 0 until 4) {
            val nextR = curR + dr[i]
            val nextC = curC + dc[i]

            if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) continue

            if(visited[nextR][nextC] == 0) continue

            if(visited[nextR][nextC] == 1) {
                visited[nextR][nextC] = 0
                deque.add(Pair(nextR, nextC))
            }
        }
    }

    return tmpCnt
}

