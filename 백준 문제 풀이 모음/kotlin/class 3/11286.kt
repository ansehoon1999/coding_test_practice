import java.lang.Math.abs
import java.util.*


fun main() = with(System.`in`.bufferedReader()){
    val sb = StringBuilder()
    val list = PriorityQueue<Int> ( kotlin.Comparator { o1, o2 ->
        val abs1 = abs(o1)
        val abs2 = abs(o2)

        when {
            abs1 == abs2 -> o1 - o2
            else -> abs1 - abs2
        }
    })

    val n = readLine().toInt()
    repeat(n) {
        val input = readLine().toInt()
        if (input == 0) {
            if(list.size == 0) {
                sb.append(0)
                sb.append('\n')
            } else {
                sb.append(list.poll())
                sb.append('\n')
            }
        } else {
            list.add(input)
        }
    }

    println(sb.toString())
}
