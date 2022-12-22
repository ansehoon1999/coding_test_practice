import java.util.PriorityQueue

fun main() = with(System.`in`.bufferedReader()){
    val (a, b) = readLine().split(' ').toList().map { it.toLong() }

    bfs(a, b)


}

fun bfs(a: Long, b: Long) {

    val deque = ArrayDeque<MutableSet<Long>>()
    deque.add(mutableSetOf(a))
    var count = 1

    while (true) {

        if (deque[0].isEmpty()) {
            println(-1)
            break
        }

        val node = deque.removeFirst() // (2)

        if (node.contains(b)) {
            println(count)
            break
        }

        val new_set = mutableSetOf<Long>()
        node.forEach {
            if (it * 2 <= b) {
                new_set.add(it * 2)
            }

            if (it * 10 + 1 <= b) {
                new_set.add(it * 10 + 1)
            }
        }

        deque.add(new_set)
        count ++
    }
}
