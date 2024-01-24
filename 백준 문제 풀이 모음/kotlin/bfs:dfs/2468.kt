import java.io.BufferedReader
import java.io.InputStreamReader

val dr = listOf(1, -1, 0, 0)
val dc = listOf(0, 0, 1, -1)

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val region = mutableListOf<MutableList<Int>>()

    var min = 0
    var max = 0

    repeat(n) {
        val list = br.readLine().split(" ").map { it.toString().toInt() }.toMutableList()
        region.add(list)
        min = minOf(min, list.minOf { it })
        max = maxOf(max, list.maxOf { it })
    }



    var result = 0

    for(idx in min .. max) {

        val watered = MutableList<MutableList<Boolean>>(region.size) {
            MutableList<Boolean>(region[0].size) { false }
        }

        /**
         * 1. N 미만인 곳 watered
         */

        for (r in 0 until region.size) {
            for (c in 0 until region[0].size) {
                if (region[r][c] < idx) {
                    watered[r][c] = true
                }
            }

        }

        /**
         * 2. 안전한 영역 구하기 with bfs
         */

        var cnt = 0

        for (r in 0 until region.size) {
            for (c in 0 until region[0].size) {
                if (!watered[r][c]) {
                    bfs(watered, r, c, region.size, region[0].size)
                    cnt++
                }
            }
        }

        result = maxOf(result, cnt)

//        region.forEach {
//            println(it)
//        }
//
//        println()
//
//        watered.forEach {
//            println(it)
//        }
//        println()
    }



    println(result)
}

fun bfs(watered: MutableList<MutableList<Boolean>>, r: Int, c: Int, rowLen: Int, colLen: Int) {

    val deque = ArrayDeque<Pair<Int, Int>>()
    deque.add(Pair(r, c))
    watered[r][c] = true

    while(deque.isNotEmpty()) {
        val cur = deque.removeFirst()
        val curR = cur.first
        val curC = cur.second

        for(i in 0 until 4) {
            val nextR = curR + dr[i]
            val nextC = curC + dc[i]

            if(nextR < 0 || nextR >= rowLen || nextC < 0 || nextC >= colLen) continue

            if(watered[nextR][nextC]) continue

            if(!watered[nextR][nextC]) {
                watered[nextR][nextC] = true
                deque.add(Pair(nextR, nextC))
            }
        }
    }

}
