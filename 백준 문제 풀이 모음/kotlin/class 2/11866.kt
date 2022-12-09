fun main() = with(System.`in`.bufferedReader()) {
    val str = readLine().split(' ').toList()
    val n = str[0].toInt()
    val k = str[1].toInt()

    val queue = ArrayDeque<Int>()
    for ( i in 1 .. n) {
        queue.add(i)
    }

    val sb = StringBuilder()
    sb.append('<')
    while ( queue.isNotEmpty()) {
        for (i in 0 until k-1) {
            queue.add(queue.removeFirst())
        }

        if (queue.size == 1 ) { sb.append("${queue.removeFirst()}>") }
        else {
            sb.append("${queue.removeFirst()}, ")
        }
    }
    println(sb.toString())
}