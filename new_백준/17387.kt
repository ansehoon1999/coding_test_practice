import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

data class Point(
    val x: Long,
    val y: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val points = mutableListOf<Point>()

    repeat(2) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toLong() }
        points.add(Point(x1, y1))
        points.add(Point(x2, y2))
    }

    val A = points[0]
    val B = points[1]
    val C = points[2]
    val D = points[3]

    fun ccw(point1: Point, point2: Point, point3: Point): Int {

        val result = (point1.x * point2.y + point2.x * point3.y + point3.x * point1.y) -
                (point2.x * point1.y + point3.x * point2.y + point1.x * point3.y)

        if(result > 0) {
            return 1
        } else if(result < 0) {
            return -1
        } else {
            return 0
        }
    }

    fun isOverLab(point1: Point, point2: Point, point3: Point, point4: Point): Boolean {
        if((minOf(point1.x, point2.x) <= maxOf(point3.x, point4.x)) and (minOf(point3.x, point4.x) <= maxOf(point1.x, point2.x))
            and (minOf(point1.y, point2.y) <= maxOf(point3.y, point4.y)) and (minOf(point3.y, point4.y) <= maxOf(point1.y, point2.y))) {
            return true
        } else return false
    }

    val abc = ccw(A,B,C)
    val abd = ccw(A,B,D)

    val cda = ccw(C,D,A)
    val cdb = ccw(C,D,B)

    if((abc * abd == 0) and (cda * cdb == 0)) {
        if(isOverLab(A, B, C, D)) {
            println(1)
            return
        } else {
            println(0)
            return
        }
    } else if((abc * abd <= 0) and (cda * cdb <= 0)) {
        println(1)
        return
    }

    println(0)


    /**
     * 1 5 7 1
     * 1 5 3 1
     */


    writer.flush()
    writer.close()
}


