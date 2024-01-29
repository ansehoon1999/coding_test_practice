package com.sample.myapplication.ui.theme

import java.io.BufferedReader
import java.io.InputStreamReader


val dr = listOf(1, -1, 0, 0)
val dc = listOf(0, 0, 1, -1)

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val (m, n) = br.readLine().split(" ").map { it.toInt() }

    val matrix = mutableListOf<MutableList<Int>>()

    repeat(n) {
        val line = br.readLine().split(" ").map { it.toInt() }.toMutableList()
        matrix.add(line)
    }

    var startList = mutableListOf<Pair<Int, Int>>()
    for(row in 0 until n) {
        for(col in 0 until m) {
            if(matrix[row][col] == 1) {
                startList.add(Pair(row, col))
            }
        }
    }


    val deque = ArrayDeque<MutableList<Pair<Int, Int>>>()
    deque.add(startList)

    var cnt = 0

    while(deque.isNotEmpty()) {

        val curList = deque.removeFirst()
        val tmpList = mutableListOf<Pair<Int, Int>>()

//        matrix.forEach{
//            println(it)
//        }
//        println()

        if(curList.isEmpty()) {
            break
        }

        curList.forEach {
            val curRow = it.first
            val curCol = it.second

            for(i in 0 until 4) {

                val nextRow = curRow + dr[i]
                val nextCol = curCol + dc[i]

                if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m) continue

                if(matrix[nextRow][nextCol] == 0) {
                    matrix[nextRow][nextCol] = 1
                    tmpList.add(Pair(nextRow, nextCol))
                }
            }
        }

        deque.add(tmpList)
        cnt ++
    }


//    matrix.forEach {
//        println(it)
//    }

    var flag = true
    for(row in 0 until n) {
        for(col in 0 until m) {
            if(matrix[row][col] == 0) {
                flag = false
            }
        }
    }

    if(flag) {
        println(cnt - 1)
    } else {
        println(-1)
    }

}




