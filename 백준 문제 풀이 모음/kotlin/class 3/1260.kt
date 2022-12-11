package class3

// DFS와 BFS

private var arr = Array(0) { MutableList(0) {0} }
private var visited = Array(0) { false }
val sb = StringBuilder()
fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine().split(' ').toList()
    val n = str[0].toInt()
    val m = str[1].toInt()
    val v = str[2].toInt()

    arr = Array (n+1) { MutableList(0) {0} }
    visited = Array<Boolean> (n+1) {false}
    repeat(m) {
        val str2 = readLine().split(' ').toList()
        val a = str2[0].toInt()
        val b = str2[1].toInt()

        arr[a].add(b)
        arr[b].add(a)

    }


    arr.forEach {
        it.sort()
    }


    DFS(v)

    sb.append('\n')
    visited = Array<Boolean> (n+1) {false}
    BFS(v)


    println(sb.toString())

}


fun DFS(v: Int) {
    sb.append(v)
    sb.append(' ')

    visited[v] = true
    arr[v].forEach {
        if (!visited[it]) {
            DFS(it)
        }
    }
}

fun BFS(v: Int) {

    visited[v] = true
    val queue = ArrayDeque<Int>()
    queue.add(v)

    while (queue.size != 0) {
        val value = queue.removeFirst()

        sb.append(value)
        sb.append(' ')
        arr[value].forEach {
            if (!visited[it]) {
                queue.add(it)
                visited[it] = true
            }
        }

    }

}

