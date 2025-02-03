import java.io.BufferedReader
import java.io.InputStreamReader

data class Node(
    val next: Int,
    val p: Int,
    val q: Int
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()


    val n = br.readLine().toInt()
    val parents = br.readLine().split(" ").map { it.toInt() }.toMutableList()
    val deleteIdx = br.readLine().toInt()

    var startIdx = 0
    parents.forEachIndexed { index, i ->
        if(i == -1) startIdx = index
    }

    parents[deleteIdx] = Integer.MIN_VALUE

//    println(parents)

    var result = 0L


    val visited = MutableList<Boolean>(n) { false }

    fun dfs(nowIdx: Int) {

        var count = 0

        if(parents[nowIdx] == Integer.MIN_VALUE) return

        visited[nowIdx] = true

        parents.forEachIndexed { index, it ->
            if(!visited[index] && it == nowIdx) {
                dfs(index)
                count ++
            }
        }

        if(count == 0) {
            result ++
        }
    }

    visited[startIdx] = true
    dfs(startIdx)

    println(result)

    writer.flush()
    writer.close()
}

// a < b
fun gcd(a: Long, b: Long): Long {
    if(a == 0L) return b
    else return gcd(b % a, a)
}
