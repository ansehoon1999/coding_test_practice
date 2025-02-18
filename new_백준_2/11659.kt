import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import kotlin.math.abs



fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     *
     */

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val list = (listOf(0) + br.readLine().split(" ").map { it.toInt() }).toMutableList()

    for(i in 1 .. n) {
        list[i] += list[i-1]
    }

//    println(list)

    repeat(m) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        println(list[j] - list[i-1])
    }

    writer.flush()
    writer.close()
}















