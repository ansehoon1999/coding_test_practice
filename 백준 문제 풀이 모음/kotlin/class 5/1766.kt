import java.util.*

private lateinit var matrix : MutableList<MutableSet<Int>>
private lateinit var arr : IntArray

fun main() = with(System.`in`.bufferedReader()){
    val (n, m) = readLine().split(' ').map { it.toInt() }

    matrix = MutableList<MutableSet<Int>>(n+1) { mutableSetOf() }
    arr = IntArray(n+1)
    val result = mutableListOf<Int>()

    repeat(m) {
        val (a, b) = readLine().split(' ').map { it.toInt() }
        arr[b] += 1
        matrix[a].add(b)
    }

    val deque = PriorityQueue<Int>()
    for (i in 1 .. n) {
        if (arr[i] == 0) {
            deque.add(i)
        }
    }
//    println(deque)
    while (!deque.isEmpty()) {
        val node = deque.poll()
        result.add(node)

        matrix[node].forEach {
            arr[it] -= 1
            if (arr[it] == 0) {
                deque.add(it)
            }
        }
    }

    val sb = StringBuilder()
    result.forEach {
        sb.append(it)
        sb.append(' ')
    }
    print(sb)
//    println(arr)
//    println()
//    matrix.forEach {
//        println(it)
//    }
//    println()
//
//    println(result)
}

