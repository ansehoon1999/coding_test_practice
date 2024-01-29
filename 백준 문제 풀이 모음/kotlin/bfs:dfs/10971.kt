
import java.io.BufferedReader
import java.io.InputStreamReader

var min = Integer.MAX_VALUE

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val matrix = mutableListOf<List<Int>>()

    repeat(N) {
        val list = br.readLine().split(" ").map { it.toInt() }
        matrix.add(list)
    }

    repeat(N) {
        val visited = MutableList<Boolean>(N) { false }
        visited[it] = true
        dfs(it, matrix, visited, N, 0, 0, listOf<Int>(), it)
    }

    println(min)
}

fun dfs(start: Int, matrix: MutableList<List<Int>>, visited: MutableList<Boolean>, n: Int, total: Int, cnt: Int, list: List<Int>, first: Int) {
    if(cnt == n - 1) {

        if(matrix[start][first] != 0) {
            min = minOf(min, total + matrix[start][first])
        }
        return
    }

    for(i in 0 until n) {
        if(!visited[i] && start != i && matrix[start][i] != 0) {
            visited[i] = true
            dfs(i, matrix, visited, n, total + matrix[start][i], cnt + 1, list + listOf(matrix[start][i]), first)
            visited[i] = false
        }
    }

}