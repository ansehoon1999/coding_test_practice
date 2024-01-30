import java.io.BufferedReader
import java.io.InputStreamReader

import java.io.*;
import java.util.*;



fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val (M, N, K) = br.readLine().split(" ").map { it.toInt() }

    val matrix = MutableList<MutableList<Boolean>>(M) {
        MutableList<Boolean>(N) { false }
    }

    repeat(K) {
        val (x1, y1, x2, y2) = br.readLine().split(" ").map { it.toInt() }

        val row1 = M - 1 - y1
        val row2 = M - y2

        val col1 = x1
        val col2 = x2 - 1

        for(r in row2 .. row1) {
            for(c in col1 .. col2) {
                matrix[r][c] = true
            }
        }

//        println("point1: ${Pair(row1, col1)} point2: ${Pair(row2, col2)}")
    }

    val regionList = mutableListOf<Int>()
    for(r in 0 until M) {
        for(c in 0 until N) {
            if(!matrix[r][c]) {

                regionList.add(bfs(matrix, r, c, N, M))
//                println(regionList)
            }
        }
    }

    val sb = StringBuilder()
    regionList.sort()

    for(i in 0 until regionList.size) {

        sb.append(regionList[i])
        if(i != regionList.size - 1) {
            sb.append(" ")
        }
    }

    println(regionList.size)
    println(sb.toString())

}

val dr = listOf(1, -1, 0, 0)
val dc = listOf(0, 0, 1, -1)

fun bfs(matrix: MutableList<MutableList<Boolean>>, r: Int, c: Int, n: Int, m: Int): Int {

    var tmpCnt = 1

    val deque = ArrayDeque<Pair<Int, Int>>()
    deque.add(Pair(r, c))
    matrix[r][c] = true

    while(deque.isNotEmpty()) {
        val first = deque.removeFirst()

        val curRow = first.first
        val curCol = first.second

        for(i in 0 until 4) {
            val nextRow = curRow + dr[i]
            val nextCol = curCol + dc[i]

            if(nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) continue

            if(matrix[nextRow][nextCol]) continue

            matrix[nextRow][nextCol] = true
            deque.add(Pair(nextRow, nextCol))
            tmpCnt ++
        }
    }

    return tmpCnt
}