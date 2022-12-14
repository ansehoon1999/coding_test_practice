package class3

var connect = Array(0) { MutableList(0) { 0 } }
var visited = Array(0) { false }

val dfs = mutableListOf<Int>()
fun main() = with(System.`in`.bufferedReader()) {
    val computer = readLine().toInt()
    val pair = readLine().toInt()

    connect = Array(computer+1) { MutableList(0) { 0 } }
    visited = Array(computer+1) { false }
    repeat(pair) {
        val input = readLine().split(' ').toList()
        val a = input[0].toInt()
        val b = input[1].toInt()

        connect[a].add(b)
        connect[b].add(a)

    }

    DFS(1)

    print(dfs.size-1)
//    connect.forEach {
//        println(it)
//    }



}

fun DFS(i: Int) {
    dfs.add(i)
    visited[i] = true

    connect[i].forEach {
        if(!visited[it]) {
            DFS(it)
        }
    }
}
