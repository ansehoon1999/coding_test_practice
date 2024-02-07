import java.io.BufferedReader
import java.io.InputStreamReader

import java.io.*;
import java.util.*;


lateinit var matrix: MutableList<MutableList<String>>

lateinit var island: MutableList<MutableList<String>>

lateinit var visited: MutableList<MutableList<Boolean>>


val dr = listOf<Int>(1, -1, 0, 0)
val dc = listOf<Int>(0, 0, 1, -1)

var answer = Integer.MAX_VALUE

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()

    matrix = mutableListOf()

    island = MutableList<MutableList<String>>(N) {
        MutableList<String>(N) { "0" }
    }

    visited = MutableList<MutableList<Boolean>>(N) {
        MutableList<Boolean>(N) { false }
    }

    repeat(N) {
        val tmpList = br.readLine().split(" ").map { it.toString() }.toMutableList()
        matrix.add(tmpList)
    }

//    for(r in 0 until N) {
//        for(c in 0 until N) {
//            if(matrix[r][c] != "0") {
//                visited[r][c] = true
//            }
//        }
//    }
//

//    println("matrix")
//    matrix.forEach {
//        println(it)
//    }
//    println()
//
//    println("island")
//    island.forEach {
//        println(it)
//    }
//    println()
//
//    println("visited")
//    visited.forEach {
//        println(it)
//    }
//    println()

    var cnt = 1
    for(r in 0 until N) {
        for(c in 0 until N) {
            if(matrix[r][c] == "1" && !visited[r][c]) {
                divideIsland(N, r, c, cnt)
                cnt ++
            }
            else  {
                continue
            }
        }
    }


    for(r in 0 until N) {
        for(c in 0 until N) {
            if(island[r][c] != "0") {
                visited = MutableList<MutableList<Boolean>>(N) {
                    MutableList<Boolean>(N) { false }
                }
                findShortBridge(N, r, c, island[r][c])
            }
        }
    }

    println(answer)
}

fun findShortBridge(n: Int, r: Int, c: Int, islandNum: String) {

    val deque = ArrayDeque<Point>()
    deque.add(Point(r, c, 0))

    visited[r][c] = true

    while(deque.isNotEmpty()) {
        val curPoint = deque.removeFirst()

        for(i in 0 until 4) {
            val nextR = curPoint.r + dr[i]
            val nextC = curPoint.c + dc[i]

            if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) continue

            if(visited[nextR][nextC]) continue

            if(island[nextR][nextC] == islandNum) continue

            visited[nextR][nextC] = true
            if(matrix[nextR][nextC] == "0") {
                deque.add(Point(nextR, nextC, curPoint.cnt + 1))
            } else {
                answer = minOf(answer, curPoint.cnt)
            }
        }
    }

}

data class Point(
    val r: Int,
    val c: Int,
    val cnt: Int
)


fun divideIsland(n: Int, r: Int, c: Int, cnt: Int) {

    island[r][c] = cnt.toString()

    val deque = ArrayDeque<Pair<Int, Int>>()
    deque.add(Pair(r, c))

    while(deque.isNotEmpty()) {
        val (curR, curC) = deque.removeFirst()

        for(i in 0 until 4) {
            val nextR = curR + dr[i]
            val nextC = curC + dc[i]

            if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) continue

            if(matrix[nextR][nextC] == "0") continue

            if(visited[nextR][nextC]) continue

            visited[nextR][nextC] = true
            island[nextR][nextC] = cnt.toString()
            deque.add(Pair(nextR, nextC))
        }
    }

//    println(cnt)
//    island.forEach {
//        println(it)
//    }
//    println()
}




