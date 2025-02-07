import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

data class Node(
    val idx: Int,
    val time: Long
)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()


    /**
     * 3 2 1
     * 2 1 3
     * 1 2 3
     */

    val st = br.readLine().split("-").map { it.toString() }

    var sum = 0

    val tmpResult = mutableListOf<Int>()

    for(idx in 0 until st.size) {
        var tmpSum = 0
        val tmpList = st[idx].split("+").map { it.toInt() }
        tmpList.forEach {
            tmpSum += it
        }

        tmpResult.add(tmpSum)
    }


    var result = tmpResult.first()

    for(idx in 1 until tmpResult.size) {
        result -= tmpResult[idx]
    }

    println(result)

    writer.flush()
    writer.close()
}


