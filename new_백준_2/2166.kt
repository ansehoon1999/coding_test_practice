import java.io.BufferedReader
import java.io.InputStreamReader

data class Point(
    val x: Long,
    val y: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

   val n = br.readLine().toInt()

    val points = mutableListOf<Point>()
    repeat(n) {
        val (a, b) =br.readLine().split(" ").map { it.toLong() }
        points.add(Point(a, b))
    }

    points.add(points[0])

    var sum = 0.0
    for(i in 0 until n) {
        sum += (points[i].x * points[i+1].y - points[i+1].x * points[i].y)
    }

    println(String.format("%.1f", kotlin.math.abs(sum / 2.0)))
}














