import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine().toInt()

    val sb = StringBuilder()
    val list = PriorityQueue<Long>(Collections.reverseOrder())
    repeat(n) {

        val input = readLine().toLong()
        if (input == 0L) {
            if (list.size == 0) {
                sb.append(0)
                sb.append('\n')
            } else {
                sb.append(list.poll())
                sb.append('\n')
            }
        } else {
            list.add(input)
        }

//        println(list)
    }

    println(sb.toString())
}