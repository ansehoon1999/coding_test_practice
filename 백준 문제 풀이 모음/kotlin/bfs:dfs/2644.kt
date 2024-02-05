import java.io.BufferedReader
import java.io.InputStreamReader

import java.io.*;
import java.util.*;



val graph = hashMapOf<Int, MutableList<Int>>()
lateinit var visited: MutableList<Boolean>

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    repeat(n) {
        graph[it+1] = mutableListOf()
    }

    visited = MutableList<Boolean>(n+1) { false }

    val (start, end) = br.readLine().split(" ").map { it.toInt() }

    val m = br.readLine().toInt()

    repeat(m) {

        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        graph[x]?.add(y)
        graph[y]?.add(x)
    }

    val deque = ArrayDeque<MutableList<Int>>()
    deque.add(mutableListOf(start))
    visited[start] = true

    var cnt = 0
    while(deque.isNotEmpty()) {
//        println(deque)
        val curList = deque.removeFirst()

        if(curList.isEmpty()) {
            println(-1)
            return
        } else {
            if(curList.contains(end)) {
                println(cnt)
                return
            }
        }

        val tmpList = mutableListOf<Int>()

        curList.forEach { cur ->
            graph[cur]?.forEach { next ->
                if(!visited[next]) {
                    visited[next] = true
                    tmpList.add(next)
                }
            }
        }

        deque.add(tmpList)
        cnt ++
    }


}