import java.io.BufferedReader
import java.io.InputStreamReader

data class Point(
    val x: Long,
    val y: Long
)

data class Segment(
    val p1: Point,
    val p2: Point
)

fun ccw(p1: Point, p2: Point, p3: Point): Int {
    val tmp = (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y)
    if (tmp > 0) return 1
    else if (tmp < 0) return -1
    else return 0
}

fun isOverLab(p1: Point, p2: Point, p3: Point, p4: Point): Boolean {
    return ((minOf(p1.x, p2.x) <= maxOf(p3.x, p4.x)) and
            (minOf(p1.y, p2.y) <= maxOf(p3.y, p4.y)) and
            (minOf(p3.x, p4.x) <= maxOf(p1.x, p2.x)) and
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
        } else {
            return false
        }
    } else if ((abc * abd <= 0) and (cda * cdb <= 0)) {
        return true
    } else {
        return false
    }
}

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val segmentList = mutableListOf<Segment>()

    val parents = MutableList<Int>(n) { it }

    repeat(n) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toLong() }
        segmentList.add(Segment(Point(x1, y1), Point(x2, y2)))
    }

    fun find(a: Int): Int {
        if (a == parents[a]) {
            return a
        } else {
            parents[a] = find(parents[a])
            return parents[a]
        }
    }

    fun union(a: Int, b: Int) {
        val a = find(a)
        val b = find(b)

        if (a != b) {
            parents[b] = a
        }
    }

    for (i in 0 until n) {
        val curSegment = segmentList[i]
        for (j in 0 until n) {
            val nextSegment = segmentList[j]

            if (isIntersect(curSegment.p1, curSegment.p2, nextSegment.p1, nextSegment.p2)) {
                union(i, j)
            }
        }
    }

    val hashMap = hashMapOf<Int, Int>()

    for (i in 0 until parents.size) {
        val findParents = find(parents[i])
        if(hashMap[findParents] == null) {
            hashMap[findParents] = 1
        } else {
            hashMap[findParents] = hashMap[findParents]!! + 1
        }
    }


    println(hashMap.size)

    var maxCnt = 0
    hashMap.forEach {
        maxCnt = maxOf(maxCnt, it.value)
    }

    println(maxCnt)
}










