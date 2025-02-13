import java.io.BufferedReader
import java.io.InputStreamReader

data class Point(
    val x: Long,
    val y: Long
)

fun ccw(p1: Point, p2: Point, p3: Point): Int {
    val tmp = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y)
    if (tmp > 0) return 1
    else if (tmp < 0) return -1
    else return 0
}

fun isOverLab(p1: Point, p2: Point, p3: Point, p4: Point): Boolean {
    return ((minOf(p1.x, p2.x) <= maxOf(p3.x, p4.x)) and
            (minOf(p3.x, p4.x) <= maxOf(p1.x, p2.x)) and
            (minOf(p1.y, p2.y) <= maxOf(p3.y, p4.y)) and
            (minOf(p3.y, p4.y) <= maxOf(p1.y, p2.y)))
}

fun isIntersect(p1: Point, p2: Point, p3: Point, p4: Point): Boolean {
    val abc = ccw(p1, p2, p3)
    val abd = ccw(p1, p2, p4)
    val cda = ccw(p3, p4, p1)
    val cdb = ccw(p3, p4, p2)

    if ((abc * abd == 0) and (cda * cdb == 0)) {
        if (isOverLab(p1, p2, p3, p4)) {
            return true
        } else return false
    } else if ((abc * abd <= 0) and (cda * cdb <= 0)) {
        return true
    } else {
        return false
    }
}


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toLong() }
    val (x3, y3, x4, y4) = br.readLine().split(" ").map { it.toLong() }

    if(isIntersect(Point(x1, y1), Point(x2, y2), Point(x3, y3), Point(x4, y4))) {
        println(1)
    } else {
        println(0)
    }

}










