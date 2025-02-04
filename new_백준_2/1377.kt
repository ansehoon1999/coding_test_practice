import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()


    /**
     *
     * 10 1 5 4
     *
     */

    val n = br.readLine().toInt()

    val aList = mutableListOf<Pair<Int, Int>>()

    repeat(n) {
        aList.add(Pair(it, br.readLine().toInt()))
    }

    val newList = aList.sortedBy { it.second }


    var result = 0
    for(i in 0 until n) {
        result = maxOf(result, newList[i].first - aList[i].first)
    }

    println(result+1)
    writer.flush()
    writer.close()
}


