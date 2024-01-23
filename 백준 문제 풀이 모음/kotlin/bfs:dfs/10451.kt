import java.io.*;
import java.util.*;

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))

    val sb = StringBuilder()

    val testCase = br.readLine().toInt()

    repeat(testCase) {
        val total = br.readLine().toInt()
        val nextList = listOf(0) + br.readLine().split(" ").map { it.toInt() }

        val arr = IntArray(total + 1)

        nextList.forEachIndexed { idx, value ->
            arr[idx] = value
        }

        val visited = BooleanArray(total + 1) { false }

//        println(nextList)
//        println(arr.toList())
//        println(visited.toList())

        var cnt = 0

        for(idx in 1 .. total) {

            if(!visited[idx]) {
                dfs(idx, nextList, visited)

                cnt++
//                println(visited.toList())


            }
        }

        sb.append("${cnt}")

        if(testCase - 1 != it) {
            sb.append("\n")
        }
//        println(cnt)
    }

    println(sb.toString())

//    println()
}

fun dfs(idx: Int, nextList: List<Int>, visited: BooleanArray) {

    if(visited[idx]) return

    visited[idx] = true
    val next = nextList[idx]

    dfs(next, nextList, visited)

}