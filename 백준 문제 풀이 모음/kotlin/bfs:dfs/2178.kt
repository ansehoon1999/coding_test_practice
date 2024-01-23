import java.io.*;
import java.util.*;
import kotlin.collections.ArrayDeque


val dr = listOf<Int>(1, -1, 0, 0)
val dc = listOf<Int>(0, 0, 1, -1)

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val matrix = mutableListOf<MutableList<Int>>()


    for (i in 1..N) {
        val strList = br.readLine().toList().map { it.toString().toInt() }.toMutableList()
        matrix.add(strList)
    }

    val deque = ArrayDeque<MutableList<Pair<Int, Int>>>()
    deque.add(mutableListOf(Pair(0, 0)))
    matrix[0][0] = 0

    var flag = true
    var count = 0

    while (deque.isNotEmpty()) {
        val curList = deque.removeFirst()

        val tmpList = mutableListOf<Pair<Int, Int>>()

        for (idx in 0 until curList.size) {
            val cur = curList[idx]

            val curR = cur.first
            val curC = cur.second

            if (curR == N - 1 && curC == M - 1) {
                flag = false
                break
            }

            for (i in 0 until 4) {
                val nextR = curR + dr[i]
                val nextC = curC + dc[i]

                if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue

                if (matrix[nextR][nextC] == 0) continue

                matrix[nextR][nextC] = 0
                tmpList.add(Pair(nextR, nextC))

            }
        }

        if (flag) {
            deque.add(tmpList)
            count++
        }

//        matrix.forEach {
//            println(it)
//        }
//        println()
    }


    println(count + 1)


}
