
var matrix = MutableList<MutableList<Int>>(0) { MutableList(0) { 0 } }
var visited = MutableList<Int>(0) { 0 }

fun main() = with(System.`in`.bufferedReader()){
    val str = readLine().split(' ').toList()
    val n = str[0].toInt()
    val m = str[1].toInt()

    matrix = MutableList<MutableList<Int>>(n + 1) { MutableList(0) { 0 } }
    visited = MutableList<Int>(n + 1) { 1 }

    repeat(m) {
        val input = readLine().split(' ').toList()
        val a = input[0].toInt()
        val b = input[1].toInt()

        matrix[a].add(b)
        matrix[b].add(a)

    }

    var count = 0
    for (i in 1 .. n) {
       if (visited[i] == 1) {
           DFS(i)
           count++
       }
    }
    println(count)

}

fun DFS(i: Int) {
    visited[i] = 0
    matrix[i].forEach {
        if (visited[it] == 1) {
            visited[it] = 0
            DFS(it)
        }
    }

}

