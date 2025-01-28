import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val writer = System.out.bufferedWriter()

    val N = br.readLine().toInt()

    val primaryNumberList = MutableList<LongArray>(100) { longArrayOf(0L, 0) }
    primaryNumberList[1][0] = 0
    primaryNumberList[1][1] = 1

    primaryNumberList[2][0] = 1
    primaryNumberList[2][1] = 0

    for(idx in 3 .. N) {
        val befPrimaryNumberList = primaryNumberList[idx - 1]

        val befZeroCnt = befPrimaryNumberList[0]
        val befOneCnt = befPrimaryNumberList[1]

        primaryNumberList[idx][0] = (befZeroCnt + befOneCnt)
        primaryNumberList[idx][1] = (befZeroCnt)
    }

//    primaryNumberList.forEach {
//        println(it.toList())
//    }

    println(primaryNumberList[N][0] + primaryNumberList[N][1])

    writer.flush()
    writer.close()

}
