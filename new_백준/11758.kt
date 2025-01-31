import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val points = mutableListOf<Pair<Int, Int>>()

    repeat(3) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        points.add(Pair(x, y))
    }

    val result = (points[0].first * points[1].second + points[1].first * points[2].second  + points[2].first * points[0].second) -
            (points[1].first * points[0].second + points[2].first * points[1].second + points[0].first * points[2].second)

    if(result < 0) {
        println(-1)
    } else if(result == 0) {
        println(0)
    } else {
        println(1)
    }


    /**
     * 1 5 7 1
     * 1 5 3 1
     */


    writer.flush()
    writer.close()
}

