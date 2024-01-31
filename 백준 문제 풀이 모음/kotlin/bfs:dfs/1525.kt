import java.io.BufferedReader
import java.io.InputStreamReader

import java.io.*;
import java.util.*;



val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)

val visited = mutableSetOf<String>()

val standard = "123456780"

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    var initial = ""
    repeat(3) {
        initial += br.readLine().replace(" ", "")
    }

    println(bfs(initial))
}

fun bfs(str: String): Int {

    val deque =  ArrayDeque<Pair<String, Int>>()
    deque.add(Pair(str, 0))
    visited.add(str)

    while(deque.isNotEmpty()) {
        val cur = deque.poll()

        val coord = cur.first.indexOf('0')
        val curX = coord / 3
        val curY = coord % 3

        if(cur.first == standard) return cur.second

        for(i in 0 until 4) {
            val nextX = curX + dx[i]
            val nextY = curY + dy[i]

            if(nextX !in 0 until 3 || nextY !in 0 until 3) continue

            val nextC = nextX * 3 + nextY
            val tmp = cur.first.toCharArray()

            val tmpCost = tmp[nextC]
            tmp[nextC] = tmp[coord]
            tmp[coord] = tmpCost

            val newString = String(tmp)
            if(!visited.contains(newString)) {
                deque.add(Pair(newString, cur.second + 1))
                visited.add(newString)
            }
        }
    }

    return -1
}
