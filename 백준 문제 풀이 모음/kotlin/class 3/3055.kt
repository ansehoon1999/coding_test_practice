import java.io.BufferedReader
import java.io.InputStreamReader

import java.io.*;
import java.util.*;


lateinit var matrix: MutableList<MutableList<String>>
lateinit var visited: MutableList<MutableList<Boolean>>


val dr = listOf<Int>(1, -1, 0, 0)
val dc = listOf<Int>(0, 0, 1, -1)

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val (R, C) = br.readLine().split(" ").map { it.toInt() }

    matrix = mutableListOf()

    visited = MutableList<MutableList<Boolean>>(R) {
        MutableList<Boolean>(C) { false }
    }

    repeat(R) {
        val tmpList = br.readLine().toList().map { it.toString() }.toMutableList()
        matrix.add(tmpList)
    }

    var rStart = 0
    var cStart = 0

    var rEnd = 0
    var cEnd = 0

    for(r in 0 until R) {
        for(c in 0 until C) {
            if(matrix[r][c] == "*" || matrix[r][c] == "X" || matrix[r][c] == "S") {
                visited[r][c] = true
            }

            if(matrix[r][c] == "S") {
                rStart = r
                cStart = c
            }

            if(matrix[r][c] == "D") {
                rEnd = r
                cEnd = c
            }
        }
    }

//    visited.forEach {
//        println(it)
//    }
//
//    matrix.forEach {
//        println(it)
//    }

    val deque = ArrayDeque<MutableList<Pair<Int, Int>>>()
    deque.add(mutableListOf(Pair(rStart, cStart)))

    var cnt = 0
    while(deque.isNotEmpty()) {
        val curList = deque.removeFirst()


        if(curList.isEmpty()) {
            println("KAKTUS")
            break
        } else {
            if (curList.contains(Pair(rEnd, cEnd))) {
                println(cnt)
                break
            }
        }

        watering(visited, matrix)

        val tmpList = mutableListOf<Pair<Int, Int>>()

        curList.forEach {
            val (curR, curC) = it

            for(i in 0 until 4) {
                val nextR = curR + dr[i]
                val nextC = curC + dc[i]

                if(nextR < 0 || nextR >= matrix.size || nextC < 0 || nextC >= matrix[0].size) continue

                if(!visited[nextR][nextC]) {
                    visited[nextR][nextC] = true
                    tmpList.add(Pair(nextR, nextC))
                }
            }
        }

//        visited.forEach {
//            println(it)
//        }
//        println()

        deque.add(tmpList)
        cnt ++
    }
}

fun watering(visited: MutableList<MutableList<Boolean>>, matrix: MutableList<MutableList<String>>) {

    val starDeque = ArrayDeque<Pair<Int, Int>>()

    for(r in 0 until matrix.size) {
        for(c in 0 until matrix[0].size) {
            if(matrix[r][c] == "*") {
                starDeque.add(Pair(r, c))
            }
        }
    }

    while(starDeque.isNotEmpty()) {
        val (curR, curC) = starDeque.removeFirst()

        for(i in 0 until 4) {
            val nextR = curR + dr[i]
            val nextC = curC + dc[i]

            if(nextR < 0 || nextR >= matrix.size || nextC < 0 || nextC >= matrix[0].size) continue

            if(visited[nextR][nextC]) continue

            if(matrix[nextR][nextC] == "D") continue

            visited[nextR][nextC] = true
            matrix[nextR][nextC] = "*"
        }

    }

}
