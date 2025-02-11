import java.io.BufferedReader
import java.io.InputStreamReader

data class Node(
    val to: Int,
    val cost: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val n = br.readLine().toInt()

    val list = mutableListOf<Pair<Int, Int>>()

    repeat(n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        list.add(Pair(a, b))
    }

    list.sortBy { it.first }
    list.sortBy { it.second }


    var cnt = 1
    var curTime = list.first()

    for(idx in 1 until list.size) {
        if(curTime.second <= list[idx].first) {
            curTime = list[idx]
            cnt ++
        }
    }

    println(cnt)
}










