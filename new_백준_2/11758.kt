import java.io.BufferedReader
import java.io.InputStreamReader

data class Point(
    val x: Long,
    val y: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    /**
     *
     */

    val (x1, y1) = br.readLine().split(" ").map { it.toLong() }
    val (x2, y2) = br.readLine().split(" ").map { it.toLong() }
    val (x3, y3) = br.readLine().split(" ").map { it.toLong() }

    val ccw = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3)
    if(ccw > 0) println(1)
    else if(ccw < 0) println(-1)
    else println(0)
}














