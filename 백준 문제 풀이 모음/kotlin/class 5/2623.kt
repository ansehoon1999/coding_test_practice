import java.util.StringTokenizer


private lateinit var arr : MutableList<Int>
private lateinit var matrix : MutableList<MutableList<Int>>

lateinit var result : MutableList<Int>

fun main() = with(System.`in`.bufferedReader()){
    val (n, m) = readLine().split(' ').map { it.toInt() }

    arr = MutableList<Int>(n+1) { 0 }
    matrix = MutableList<MutableList<Int>>(n+1) { MutableList<Int>(0) { 0 } }
    result = mutableListOf()
    repeat(m) {
        val input = readLine().split(' ').map { it.toInt() }
        for (i in 1 until input.size ){
            if (i != 1) {
                arr[input[i]] += 1
            }

            if (i != input.size -1) {
                matrix[input[i]].add(input[i+1])
            }
        }
    }

    val deque = ArrayDeque<Int>()
    for (i in 1 until arr.size) {
        if (arr[i] == 0) {
            deque.add(i)
        }
    }

    println(deque)
    for (i in 0 until n) {
        if (deque.isEmpty()) {
            println("0")
            return
        }
        val node = deque.removeFirst()
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
        sb.append('\n')
    }
    println(sb)

}
