import java.io.BufferedReader
import java.io.InputStreamReader

data class Point(
    val x: Int,
    val y: Int
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    // parent 초기화
    val parent = MutableList<Int>(n) { it }

    val lineList = mutableListOf<Pair<Point, Point>>()
    repeat(n) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }
        lineList.add(Pair(Point(x1, y1), Point(x2, y2)))
    }


    // ccw
    fun ccw(p1: Point, p2: Point, p3: Point): Int {
        val result =
            (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p2.x * p1.y + p3.x * p2.y + p1.x * p3.y)

        if(result > 0) return 1
        else if(result < 0) return -1
        else return 0
    }

    // isOverLab
    fun isOverLab(p1: Point, p2: Point, p3: Point, p4: Point): Boolean {
        return (minOf(p1.x, p2.x) <= maxOf(p3.x, p4.x)) and
                (minOf(p3.x, p4.x) <= maxOf(p1.x, p2.x)) and
                (minOf(p1.y, p2.y) <= maxOf(p3.y, p4.y)) and
                (minOf(p3.y, p4.y) <= maxOf(p1.y, p2.y))
    }

    // isIntersect
    fun isIntersect(p1: Point, p2: Point, p3: Point, p4: Point): Boolean {
        val abc = ccw(p1, p2, p3)
        val abd = ccw(p1, p2, p4)
        val cda = ccw(p3, p4, p1)
        val cdb = ccw(p3, p4, p2)

         if((abc * abd == 0) and (cda * cdb == 0)) {
             return isOverLab(p1, p2, p3, p4)
        } else if((abc * abd <= 0) and (cda * cdb <= 0)) {
            return true
        }

        return false
    }


    // union-find
    fun find(a: Int): Int {
        if (a == parent[a]) return a
        else {
            parent[a] = find(parent[a])
            return parent[a]
        }
    }

    fun union(a: Int, b: Int) {
        val a = find(a)
        val b = find(b)

        if (a != b) {
            parent[b] = a
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if(i != j) {
                if(isIntersect(lineList[i].first, lineList[i].second, lineList[j].first, lineList[j].second)) {
                    union(i, j)
                }
            }
        }
    }


    val cntList = MutableList<Int>(n) { 0 }

    parent.forEach {
        cntList[find(it)] += 1
    }

    var groupSize = 0
    var maxGroupCnt = 0

    cntList.forEach {
        if(it != 0) {
            maxGroupCnt ++
            groupSize = maxOf(groupSize, it)
        }
    }


    println(maxGroupCnt)
    println(groupSize)




    writer.flush()
    writer.close()
}


