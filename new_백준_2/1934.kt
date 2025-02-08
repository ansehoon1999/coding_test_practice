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

    val t = br.readLine().toInt()

    // a < b
    fun gcd(a: Long, b: Long): Long {
        if(a == 0L) {
            return b
        } else {
            return gcd(b % a, a)
        }
    }

    repeat(t) {
        val (a, b) = br.readLine().split(" ").map { it.toLong() }
        println(a * b / gcd(minOf(a, b), maxOf(a, b)))
    }



    writer.flush()
    writer.close()
}


