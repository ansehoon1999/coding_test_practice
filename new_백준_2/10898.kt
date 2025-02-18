import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer

data class Node(
    val idx: Int,
    val value: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     *
     */

    val n = br.readLine().toInt()

    val list = MutableList<Int>(10000001) { 0 }

    repeat(n) {
        val idx = br.readLine().toInt()
        list[idx] ++
    }


    list.forEachIndexed { index, i ->
        repeat(i) {
            writer.write("${index}\n")
        }
    }

    writer.flush()
    writer.close()
}















