import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue


data class Node(
    val to: Int,
    val weight: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()


    // a < b
    fun gcd(a: Long, b: Long): Long {
        if(a == 0L) {
            return b
        } else {
            return gcd(b % a, a)
        }
    }

    val (a, b) = br.readLine().split(" ").map { it.toLong() }

    val sb = StringBuilder()
    for(i in 0 until gcd(minOf(a, b), maxOf(a, b))) {
        sb.append("1")
    }

    writer.write(sb.toString())

    writer.flush()
    writer.close()
}


