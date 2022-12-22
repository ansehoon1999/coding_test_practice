

lateinit var list : MutableList<MutableList<Int>>
lateinit var tree : MutableList<Int>
lateinit var visited : MutableList<Boolean>
fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    tree = MutableList<Int>(n+1) { it }
    visited = MutableList<Boolean>(n+1) { false }
    list = MutableList<MutableList<Int>>(n+1) { MutableList<Int>(0) { 0 } }

    repeat(n-1) {
        val (a, b) = readLine().split(' ').toList().map { it.toInt() }

        list[a].add(b)
        list[b].add(a)
    }

    dfs(1)
    val sb = StringBuilder()

    for (i in 2 until n+1) {
        sb.append(tree[i])
        sb.append('\n')
    }
    println(sb.toString())
}

fun dfs(node: Int) {

    if (visited[node] == false) {
        visited[node] = true

        list[node].forEach {

            if (visited[it] == false) {
                tree[it] = node
                dfs(it)
            }
        }
    }
}


